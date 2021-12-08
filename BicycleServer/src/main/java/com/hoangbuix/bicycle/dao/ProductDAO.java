package com.hoangbuix.bicycle.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAO<E> extends CommonDAO<E> {
    E findByProductName(String productName);
}
