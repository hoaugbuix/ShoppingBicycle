package com.hoangbuix.bicycle.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO<E> extends CommonDAO<E> {
    E findByUsernameOrEmail(String username, String email);

    E findByEmail(String email);
}
