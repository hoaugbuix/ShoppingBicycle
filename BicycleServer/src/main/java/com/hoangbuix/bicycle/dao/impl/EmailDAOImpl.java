package com.hoangbuix.bicycle.dao.impl;

import com.hoangbuix.bicycle.dao.EmailDAO;
import com.hoangbuix.bicycle.entity.EmailEntity;
import com.hoangbuix.bicycle.model.mapper.EmailMapper;
import com.hoangbuix.bicycle.util.QueryConstant;
import com.hoangbuix.bicycle.util.SqlConstant;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional(rollbackFor = Exception.class)
public class EmailDAOImpl extends BaseDAOImpl<EmailEntity> implements EmailDAO<EmailEntity> {
    final Logger log = Logger.getLogger(EmailDAOImpl.class);
    final String EMAIL = "email";

    @Override
    public int save(EmailEntity email) {
        return insert(QueryConstant.callQuery(EMAIL, SqlConstant.CREATE, email.getContentEmail(),
                email.getContentEmail()), email.getContentEmail(), email.getSeen());
    }

    @Override
    public void update(EmailEntity email) {
        update(QueryConstant.callQuery(EMAIL, SqlConstant.UPDATE, email.getId(),
                email.getContentEmail(), email.getSeen(), email.getActiveFlag()),
                email.getId(), email.getContentEmail(), email.getSeen(), email.getActiveFlag());
    }

    @Override
    public void delete(int id) {
        delete(QueryConstant.callQuery(EMAIL, SqlConstant.DELETE, id), id);
    }

    @Override
    public List<EmailEntity> findAll() {
        return query(QueryConstant.callQuery(EMAIL, SqlConstant.FIND_ALL, null),
                new EmailMapper());
    }

    @Override
    public EmailEntity findById(int id) {
        List<EmailEntity> email = query(QueryConstant.callQuery(EMAIL, SqlConstant.FIND_BY_ID, id), new EmailMapper(), id);
        return email.isEmpty() ? null : email.get(0);
    }

    @Override
    public EmailEntity findBySeen(long seen) {
        List<EmailEntity> email = query(QueryConstant.callQuery(EMAIL, (SqlConstant.FIND_BY_ + "Seen"), seen), new EmailMapper(), seen);
        return email.isEmpty() ? null : email.get(0);
    }

    @Override
    public EmailEntity findByContentEmail(String content) {
        List<EmailEntity> email = query(QueryConstant.callQuery(EMAIL, (SqlConstant.FIND_BY_ + "ContentEmail"), content), new EmailMapper(), content);
        return email.isEmpty() ? null : email.get(0);
    }
}
