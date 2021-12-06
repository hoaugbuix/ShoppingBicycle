package com.hoangbuix.bicycle.service.Impl;

import com.hoangbuix.bicycle.dao.EmailDAO;
import com.hoangbuix.bicycle.entity.EmailEntity;
import com.hoangbuix.bicycle.exception.DuplicateRecordException;
import com.hoangbuix.bicycle.exception.NotFoundException;
import com.hoangbuix.bicycle.model.request.create.CreateEmailReq;
import com.hoangbuix.bicycle.model.request.update.UpdateEmailReq;
import com.hoangbuix.bicycle.service.EmailService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmailServiceImpl implements EmailService {
    final Logger log = Logger.getLogger(EmailServiceImpl.class);

    @Autowired
    private EmailDAO<EmailEntity> emailDAO;

    @Override
    public int save(CreateEmailReq req) {
        EmailEntity email = emailDAO.findBySeen(req.getSeen());
        EmailEntity emailNew = new EmailEntity();
        if (email == null) {
            emailNew.setContentEmail(req.getContentEmail());
            emailNew.setSeen(req.getSeen());
        } else {
            throw new DuplicateRecordException("Dup rồi!");
        }
        return emailDAO.save(emailNew);
    }

    @Override
    public void update(UpdateEmailReq req, int id) {
        try {
            EmailEntity brands = emailDAO.findBySeen(req.getSeen());
            EmailEntity emailNew = new EmailEntity();
            if (brands == null) {
                emailNew.setId(id);
                emailNew.setContentEmail(req.getContentEmail());
                emailNew.setSeen(req.getSeen());
                emailNew.setActiveFlag(req.getActiveFlag());
                emailDAO.update(emailNew);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        EmailEntity email = emailDAO.findById(id);
        if (email == null) {
            throw new NotFoundException("No find ID!");
        }
        emailDAO.delete(id);
    }

    @Override
    public List<EmailEntity> findAll() {
        return emailDAO.findAll();
    }

    @Override
    public EmailEntity findById(int id) {
        return emailDAO.findById(id);
    }

    @Override
    public EmailEntity findByContentEmail(String contentEmail) {
        return null;
    }

    @Override
    public EmailEntity findBySeen(long seen) {
        return emailDAO.findBySeen(seen);
    }

}
