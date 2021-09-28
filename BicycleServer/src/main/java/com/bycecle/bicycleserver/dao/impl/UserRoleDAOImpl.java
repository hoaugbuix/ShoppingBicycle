package com.bycecle.bicycleserver.dao.impl;

import com.bycecle.bicycleserver.dao.UserRoleDAO;
import com.bycecle.bicycleserver.entity.UserRoleEntity;
import com.bycecle.bicycleserver.model.mapper.UserRoleMapper;
import com.bycecle.bicycleserver.util.QueryConstant;
import com.bycecle.bicycleserver.util.SqlConstant;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional(rollbackFor = Exception.class)
public class UserRoleDAOImpl extends BaseDAOImpl<UserRoleEntity> implements UserRoleDAO<UserRoleEntity> {
    private final String USER_ROLE = "userRole";

    @Override
    public int save(UserRoleEntity userRole) {
        return insert(QueryConstant.callQuery(USER_ROLE, SqlConstant.CREATE, userRole), userRole.getUsers().getId(),
                userRole.getRoles().getId());
    }

    @Override
    public void update(UserRoleEntity userRole) {
        update(QueryConstant.callQuery(USER_ROLE, SqlConstant.UPDATE, userRole), userRole.getUsers().getId(),
                userRole.getRoles().getId(), userRole.getActiveFlag());
    }

    @Override
    public void delete(int id) {
        delete(QueryConstant.callQuery(USER_ROLE, SqlConstant.DELETE, id), id);
    }

    @Override
    public List<UserRoleEntity> findAll() {
        return query(QueryConstant.callQuery(USER_ROLE, SqlConstant.FIND_ALL, null), new UserRoleMapper());
    }

    @Override
    public UserRoleEntity findById(int id) {
        List<UserRoleEntity> userRole = query(QueryConstant.callQuery(USER_ROLE, SqlConstant.FIND_BY_ID, id), new UserRoleMapper(), id);
    return userRole.isEmpty() ? null : userRole.get(0);
    }
}
