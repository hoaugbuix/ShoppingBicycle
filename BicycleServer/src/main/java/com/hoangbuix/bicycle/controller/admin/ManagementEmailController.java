package com.hoangbuix.bicycle.controller.admin;

import com.hoangbuix.bicycle.entity.EmailEntity;
import com.hoangbuix.bicycle.exception.BadRequestException;
import com.hoangbuix.bicycle.exception.DuplicateRecordException;
import com.hoangbuix.bicycle.exception.NotFoundException;
import com.hoangbuix.bicycle.model.request.create.CreateEmailReq;
import com.hoangbuix.bicycle.model.request.update.UpdateEmailReq;
import com.hoangbuix.bicycle.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/email")
public class ManagementEmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("create-email")
    private ResponseEntity<?> create(@Valid @RequestBody CreateEmailReq req) {
        int id = 0;
            EmailEntity ems = emailService.findByContentEmail(req.getContentEmail());
            if (ems == null) {
                id = emailService.save(req);
            }
        EmailEntity em = emailService.findById(id);
        return new ResponseEntity<>(em, HttpStatus.OK);
    }

    @PostMapping("update-email/{id}")
    private ResponseEntity<?> update(@Valid @RequestBody UpdateEmailReq req, @PathVariable("id") int id) {
        EmailEntity brn = emailService.findById(id);
        if (brn.getContentEmail().equals(req.getContentEmail())) {
            throw new DuplicateRecordException("Dup rồi");
        } else {
            emailService.update(req, brn.getId());
        }
        return new ResponseEntity<>("Update Success!", HttpStatus.OK);
    }

    @GetMapping("/get-all")
    private ResponseEntity<?> getAll() {
        List<EmailEntity> emails = emailService.findAll();
        if (emails.isEmpty()) {
            throw new NotFoundException("kkkk");
        }
        return new ResponseEntity<>(emails, HttpStatus.OK);
    }

    @GetMapping("get-id/{id}")
    private ResponseEntity<?> getId(int id) {
        EmailEntity email = emailService.findById(id);
        if (email.getId() == null) {
            throw new NotFoundException("0");
        }
        return new ResponseEntity<>(email, HttpStatus.OK);
    }
}
