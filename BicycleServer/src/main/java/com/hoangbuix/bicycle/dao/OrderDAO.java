package com.hoangbuix.bicycle.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO<E> extends CommonDAO<E> {

    E findByStatusAndProductId(String status, int productId);

}
