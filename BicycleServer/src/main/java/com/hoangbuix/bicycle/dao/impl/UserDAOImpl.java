package com.hoangbuix.bicycle.dao.impl;

import com.hoangbuix.bicycle.dao.UserDAO;
import com.hoangbuix.bicycle.entity.UserEntity;
import com.hoangbuix.bicycle.model.mapper.UserMapper;
import com.hoangbuix.bicycle.util.QueryConstant;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.hoangbuix.bicycle.util.SqlConstant.*;

@Component
@Transactional(rollbackFor = Exception.class)
public class UserDAOImpl extends BaseDAOImpl<UserEntity> implements UserDAO<UserEntity> {
    final Logger log = Logger.getLogger(UserDAOImpl.class);
    private final String USER = "user";

    @Override
    public int save(UserEntity user) {
        return insert(QueryConstant.callQuery(USER, CREATE, user.getFirstName(), user.getLastName(),
                        user.getAvatar(), user.getUsername(), user.getPassword(), user.getEmail()), user.getFirstName(), user.getLastName(),
                user.getAvatar(), user.getUsername(), user.getPassword(), user.getEmail());
    }

    @Override
    public void update(UserEntity user) {
        update(QueryConstant.callQuery(USER, UPDATE, user.getFirstName(), user.getLastName(),
                        user.getAvatar(), user.getUsername(), user.getPassword(), user.getEmail()), user.getFirstName(), user.getLastName(),
                user.getAvatar(), user.getUsername(), user.getPassword(), user.getEmail());
    }

    @Override
    public void delete(int id) {
        delete(QueryConstant.callQuery(USER, DELETE, id), id);
    }

    @Override
    public List<UserEntity> findAll() {
        return query(QueryConstant.callQuery(USER, FIND_ALL, null), new UserMapper());
    }

    @Override
    public UserEntity findById(int id) {
        List<UserEntity> users = query(QueryConstant.callQuery(USER, FIND_BY_ID, id),
                new UserMapper(), id);
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public UserEntity findByUsernameOrEmail(String s) {
        List<UserEntity> users = query(QueryConstant.callQuery(USER, FIND_BY_USERNAME_OR_EMAIL, s),
                new UserMapper(), s);
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public UserEntity findByEmail(String email) {
        List<UserEntity> users = query(QueryConstant.callQuery(USER, FIND_BY_EMAIL, email), new UserMapper(), email);
        return users.isEmpty() ? null : users.get(0);
    }
}
