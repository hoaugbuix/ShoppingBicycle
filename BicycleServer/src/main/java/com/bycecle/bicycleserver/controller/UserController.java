package com.bycecle.bicycleserver.controller;

import com.bycecle.bicycleserver.entity.UserEntity;
import com.bycecle.bicycleserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/get-all")
    private ResponseEntity<?> findAllUser() {
        List<UserEntity> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/user/get-id/{id}")
    private ResponseEntity<?> findById(@PathVariable(value = "id") int id) {
        UserEntity user = userService.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}

