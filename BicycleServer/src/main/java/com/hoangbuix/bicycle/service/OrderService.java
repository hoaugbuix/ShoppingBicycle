package com.hoangbuix.bicycle.service;

import com.hoangbuix.bicycle.entity.OrderEntity;
import com.hoangbuix.bicycle.model.request.create.CreateOrderReq;
import com.hoangbuix.bicycle.model.request.update.UpdateOrderReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    int save(CreateOrderReq instance);

    void update(UpdateOrderReq instance);

    void delete(int id);

    List<OrderEntity> findAll();

    OrderEntity findById(int id);

    OrderEntity findByStatusAndProductId(String status, int productId);
}
