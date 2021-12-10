package com.hoangbuix.bicycle.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductSizeDAO<E> extends CommonDAO<E> {
    E findBySize(int size);

    E findByQuantity(int quantity);
}
