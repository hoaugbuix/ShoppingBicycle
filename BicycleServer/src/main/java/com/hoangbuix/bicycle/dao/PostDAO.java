package com.hoangbuix.bicycle.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface PostDAO<E> extends CommonDAO<E> {
    E findByTitle(String title);
    E findByContent(String content);
}
