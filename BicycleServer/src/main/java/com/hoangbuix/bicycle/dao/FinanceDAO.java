package com.hoangbuix.bicycle.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface FinanceDAO<E> extends CommonDAO<E> {
    E findByAmount(int amount);

//    E findByQuantity(int quantity);
}
