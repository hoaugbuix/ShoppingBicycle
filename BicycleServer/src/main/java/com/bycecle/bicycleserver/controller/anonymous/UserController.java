package com.bycecle.bicycleserver.controller.anonymous;

import com.bycecle.bicycleserver.entity.UserEntity;
import com.bycecle.bicycleserver.model.converter.UserConvert;
import com.bycecle.bicycleserver.model.request.create.CreateUserReq;
import com.bycecle.bicycleserver.security.CustomUserDetails;
import com.bycecle.bicycleserver.security.JwtTokenUtil;
import com.bycecle.bicycleserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

import static com.bycecle.bicycleserver.util.Constant.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    private ResponseEntity<?> register(@Valid @RequestBody CreateUserReq req, HttpServletResponse response){
        // Create user
        UserEntity result = userService.save(req);

        // Gen token
        UserDetails principal = new CustomUserDetails(result);
        String token = jwtTokenUtil.generateToken(principal);

        // Add token to cookie to login
        Cookie cookie = new Cookie("JWT_TOKEN",token);
        cookie.setMaxAge(MAX_AGE_COOKIE);
        cookie.setPath("/");
        response.addCookie(cookie);

        return ResponseEntity.ok(UserConvert.toDTO(result));
    }

    @GetMapping("/get-all")
    private ResponseEntity<?> findAllUser() {
        List<UserEntity> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/get-id/{id}")
    private ResponseEntity<?> findById(@PathVariable(value = "id") int id) {
        UserEntity user = userService.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}

