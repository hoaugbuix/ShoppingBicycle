package com.hoangbuix.bicycle.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface EmailDAO<E> extends CommonDAO<E> {
    E findBySeen(long seen);

    E findByContentEmail(String content);
}
