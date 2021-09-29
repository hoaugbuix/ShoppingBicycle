package com.hoangbuix.bicycle.dao.impl;

import com.hoangbuix.bicycle.dao.RoleDAO;
import com.hoangbuix.bicycle.entity.RoleEntity;
import com.hoangbuix.bicycle.model.mapper.RoleMapper;
import com.hoangbuix.bicycle.util.QueryConstant;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.hoangbuix.bicycle.util.SqlConstant.FIND_BY_ROLE_NAME;

@Component
@Transactional(rollbackFor = Exception.class)
public class RoleDAOImpl extends BaseDAOImpl<RoleEntity> implements RoleDAO<RoleEntity> {
    final String ROLE = "role";

    @Override
    public RoleEntity findByRoleName(String roleName) {
        List<RoleEntity> role = query(QueryConstant.callQuery(ROLE, FIND_BY_ROLE_NAME, roleName), new RoleMapper(), roleName);
        return role.isEmpty() ? null : role.get(0);
    }
}
