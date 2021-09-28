package com.bycecle.bicycleserver.dao.impl;

import com.bycecle.bicycleserver.dao.BaseDAO;
import com.bycecle.bicycleserver.model.mapper.RowMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional(rollbackFor = Exception.class)
public class BaseDAOImpl<E> implements BaseDAO<E> {

    @Autowired
    private DataSource dataSource;

    final static Logger log = Logger.getLogger(BaseDAOImpl.class);

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            log.info(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public <E> List<E> query(String sql, RowMapper<E> rowMapper, Object... parameters) {
        List<E> results = new ArrayList<>();
        Connection connection = null;
        CallableStatement callable = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            callable = connection.prepareCall(sql);
            setCallable(callable, parameters);
            resultSet = callable.executeQuery();
            while (resultSet.next()) {
                results.add(rowMapper.mapRow(resultSet));
            }
            return results;
        } catch (SQLException e) {
            log.error(e.getMessage());
            return null;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (callable != null) {
                    callable.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override
    public Integer queryId(String sql, RowMapper<E> rowMapper, Object... parameters) {
        Connection connection = null;
        CallableStatement callable = null;
        ResultSet resultSet = null;
        try {
            int ids = 0;
            connection = getConnection();
            callable = connection.prepareCall(sql);
            setCallable(callable, parameters);
            resultSet = callable.executeQuery();
            while (resultSet.next()) {
                ids = resultSet.getInt(1);
            }
            return ids;
        } catch (SQLException e) {
            log.error(e.getMessage());
            return null;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (callable != null) {
                    callable.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }


    private void setCallable(CallableStatement callable, Object... parameters) {
        try {
            for (int i = 0; i < parameters.length; i++) {
                Object parameter = parameters[i];
                int index = i + 1;
                if (parameter instanceof Long) {
                    callable.setLong(index, (Long) parameter);
                } else if (parameter instanceof String) {
                    callable.setString(index, (String) parameter);
                } else if (parameter instanceof Integer) {
                    callable.setInt(index, (Integer) parameter);
                } else if (parameter instanceof Timestamp) {
                    callable.setTimestamp(index, (Timestamp) parameter);
                } else if (parameter instanceof Date) {
                    callable.setDate(index, (Date) parameter);
                } else if (parameter instanceof BigDecimal) {
                    callable.setBigDecimal(index, (BigDecimal) parameter);
                } else if (parameter instanceof Float) {
                    callable.setFloat(index, (Float) parameter);
                } else if (parameter instanceof Double) {
                    callable.setDouble(index, (Double) parameter);
                } else {
                    callable.setObject(index, parameter);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String sql, Object... parameters) {
        Connection connection = null;
        CallableStatement callable = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            callable = connection.prepareCall(sql);
            setCallable(callable, parameters);
            callable.executeQuery();
            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e.printStackTrace();
                }
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (callable != null) {
                    callable.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String sql, Object... parameters) {
        Connection connection = null;
        CallableStatement callable = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            callable = connection.prepareCall(sql);
            setCallable(callable, parameters);
            callable.executeQuery();
            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e.printStackTrace();
                }
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (callable != null) {
                    callable.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override
    public Integer insert(String sql, Object... parameters) {
        Connection connection = null;
        CallableStatement callable = null;
        ResultSet resultSet = null;
        try {
            int id = 0;
            connection = getConnection();
            connection.setAutoCommit(false);
            callable = connection.prepareCall(sql);
            //set parameter
            setCallable(callable, parameters);
            callable.executeUpdate();
            resultSet = callable.getResultSet();
            if (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            connection.commit();
            return id;
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    log.error(e1.getMessage());
                    return null;
                }
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (callable != null) {
                    callable.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                log.error(e2.getMessage());
            }
        }
        return null;
    }

    @Override
    public int count(String sql, Object... parameters) {
        Connection connection = null;
        CallableStatement callable = null;
        ResultSet resultSet = null;
        try {
            int count = 0;
            connection = getConnection();
            callable = connection.prepareCall(sql);
            setCallable(callable, parameters);
            resultSet = callable.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt(0);
            }
            return count;
        } catch (SQLException e) {
            return 0;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (callable != null) {
                    callable.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e2) {
                return 0;
            }
        }
    }
}
