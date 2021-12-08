package com.hoangbuix.bicycle.dao.impl;

import com.hoangbuix.bicycle.dao.NotificationDAO;
import com.hoangbuix.bicycle.entity.NotificationEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional(rollbackFor = Exception.class)
public class NotificationDAOImpl extends BaseDAOImpl<NotificationEntity> implements NotificationDAO<NotificationEntity> {
    @Override
    public int save(NotificationEntity instance) {
        return 0;
    }

    @Override
    public void update(NotificationEntity instance) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<NotificationEntity> findAll() {
        return null;
    }

    @Override
    public NotificationEntity findById(int id) {
        return null;
    }
}
