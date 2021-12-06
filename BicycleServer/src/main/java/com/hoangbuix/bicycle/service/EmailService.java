package com.hoangbuix.bicycle.service;

import com.hoangbuix.bicycle.entity.EmailEntity;
import com.hoangbuix.bicycle.model.request.create.CreateEmailReq;
import com.hoangbuix.bicycle.model.request.update.UpdateEmailReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmailService {
    int save(CreateEmailReq instance);

    void update(UpdateEmailReq instance, int id);

    void delete(int id);

    List<EmailEntity> findAll();

    EmailEntity findById(int id);

    EmailEntity findByContentEmail(String contentEmail);

    EmailEntity findBySeen(long seen);
}
