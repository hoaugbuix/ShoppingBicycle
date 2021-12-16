package com.hoangbuix.bicycle.service;

import com.hoangbuix.bicycle.entity.PromotionEntity;
import com.hoangbuix.bicycle.model.request.create.CreatePromotionReq;
import com.hoangbuix.bicycle.model.request.update.UpdatePromotionReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PromotionService {
    int save(CreatePromotionReq instance);

    void update(UpdatePromotionReq instance);

    void delete(int id);

    List<PromotionEntity> findAll();

    PromotionEntity findById(int id);

    PromotionEntity findByCouponCode(String couponCode);
}
