package com.bycecle.bicycleserver.dao.impl;

import com.bycecle.bicycleserver.dao.RoleDAO;
import com.bycecle.bicycleserver.entity.RoleEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(rollbackFor = Exception.class)
public class RoleDAOImpl extends BaseDAOImpl<RoleEntity> implements RoleDAO<RoleEntity> {
}
