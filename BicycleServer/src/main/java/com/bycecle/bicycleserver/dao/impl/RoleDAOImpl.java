package com.bycecle.bicycleserver.dao.impl;

import com.bycecle.bicycleserver.dao.RoleDAO;
import com.bycecle.bicycleserver.entity.RoleEntity;
import com.bycecle.bicycleserver.model.mapper.RoleMapper;
import com.bycecle.bicycleserver.util.QueryConstant;
import com.bycecle.bicycleserver.util.SqlConstant;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import static com.bycecle.bicycleserver.util.SqlConstant.*;

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
