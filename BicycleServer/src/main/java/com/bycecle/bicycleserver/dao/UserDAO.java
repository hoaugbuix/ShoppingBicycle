package com.bycecle.bicycleserver.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO<E> extends CommonDAO<E> {
    E findByUsernameOrEmail(String username, String email);
}
