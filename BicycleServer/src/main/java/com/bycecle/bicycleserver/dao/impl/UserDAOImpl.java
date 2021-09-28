package com.bycecle.bicycleserver.dao.impl;

import com.bycecle.bicycleserver.dao.UserDAO;
import com.bycecle.bicycleserver.entity.UserEntity;
import com.bycecle.bicycleserver.model.mapper.UserMapper;
import com.bycecle.bicycleserver.util.QueryConstant;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import static com.bycecle.bicycleserver.util.SqlConstant.*;

@Component
@Transactional(rollbackFor = Exception.class)
public class UserDAOImpl extends BaseDAOImpl<UserEntity> implements UserDAO<UserEntity> {
    private final String USER = "user";

    @Override
    public int save(UserEntity user) {
        return insert(QueryConstant.callQuery(USER, CREATE, user), user.getFirstName(), user.getLastName(),
                user.getAvatar(), user.getUsername(), user.getPassword(), user.getEmail());
    }

    @Override
    public void update(UserEntity user) {
        update(QueryConstant.callQuery(USER, UPDATE, user), user.getFirstName(), user.getLastName(),
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
    public UserEntity findByUsernameOrEmail(String username, String email) {
        List<UserEntity> users = query(QueryConstant.callQuery(USER, FIND_BY_USERNAME_OR_EMAIL, username, email),
                new UserMapper(), username, email);
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public UserEntity findByEmail(String email) {
        List<UserEntity> users = query(QueryConstant.callQuery(USER, FIND_BY_EMAIL, email), new UserMapper(), email);
        return users.isEmpty() ? null : users.get(0);
    }
}
