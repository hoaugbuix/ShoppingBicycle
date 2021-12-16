package com.hoangbuix.bicycle.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface PromotionDAO<E> extends CommonDAO<E> {
    E findByCouponCode(String couponCode);
}
