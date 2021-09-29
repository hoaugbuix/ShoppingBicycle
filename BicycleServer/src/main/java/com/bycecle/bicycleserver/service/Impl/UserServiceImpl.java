package com.bycecle.bicycleserver.service.Impl;

import com.bycecle.bicycleserver.dao.RoleDAO;
import com.bycecle.bicycleserver.dao.UserDAO;
import com.bycecle.bicycleserver.dao.UserRoleDAO;
import com.bycecle.bicycleserver.entity.RoleEntity;
import com.bycecle.bicycleserver.entity.UserEntity;
import com.bycecle.bicycleserver.entity.UserRoleEntity;
import com.bycecle.bicycleserver.exception.BadRequestException;
import com.bycecle.bicycleserver.exception.DuplicateRecordException;
import com.bycecle.bicycleserver.model.converter.UserConvert;
import com.bycecle.bicycleserver.model.request.create.CreateUserReq;
import com.bycecle.bicycleserver.model.request.update.ChangePasswordReq;
import com.bycecle.bicycleserver.model.request.update.UpdateUserReq;
import com.bycecle.bicycleserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO<UserEntity> userDAO;

    @Autowired
    private RoleDAO<RoleEntity> roleDAO;
    @Autowired
    private UserRoleDAO<UserRoleEntity >userRoleDAO;

    @Override
    public UserEntity save(CreateUserReq req) {
        // check exist
        UserEntity user = userDAO.findByEmail(req.getEmail());
        if (user != null){
            throw new DuplicateRecordException("Tài khoản đã tồn tại!");
        }
        RoleEntity role = roleDAO.findByRoleName("user");
        if (role != null) {
            user.setRoles(Collections.singleton(role));
        }
        user = UserConvert.toEntity(req);
        int id = userDAO.save(user);
        UserEntity newUser = userDAO.findById(id);
        if (id != 0){
            UserRoleEntity userRole = new UserRoleEntity();
            userRole.setUsers(newUser);
            userRole.setRoles(role);
            userRoleDAO.save(userRole);
        }
        return userDAO.findById(id);
    }

    @Override
    public UserEntity update(UserEntity user, UpdateUserReq req) {
        int id = 0;
        if (user != null){
            user.setFirstName(req.getFirstName());
            user.setLastName(req.getLastName());
            user.setAvatar(req.getAvatar());
            user.setEmail(req.getEmail());
            id = userDAO.save(user);
        }
        return userDAO.findById(id);
    }

    @Override
    public void changePassword(UserEntity user, ChangePasswordReq req) {
        // Validate password
        if (!BCrypt.checkpw(req.getOldPassword(), user.getPassword())) {
            throw new BadRequestException("Mật khẩu cũ không chính xác");
        }

        String hash = BCrypt.hashpw(req.getNewPassword(), BCrypt.gensalt(12));
        user.setPassword(hash);
        userDAO.update(user);
    }

    @Override
    public List<UserEntity> findAll() {
        return userDAO.findAll();
    }

    @Override
    public UserEntity findById(int id) {
        return userDAO.findById(id);
    }
}
