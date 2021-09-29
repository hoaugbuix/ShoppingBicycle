package com.hoangbuix.bicycle.security;

import com.hoangbuix.bicycle.dao.UserDAO;
import com.hoangbuix.bicycle.entity.UserEntity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    final Logger log = Logger.getLogger(JwtUserDetailsService.class);
    @Autowired
    private UserDAO<UserEntity> userDAO;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        log.info("email ====== " + s);
        UserEntity user = userDAO.findByEmail(s);
        if (user != null) {
            return new CustomUserDetails(user);
        } else {
            throw new UsernameNotFoundException("User get email " + s + " does not exist.");
        }
    }
}
