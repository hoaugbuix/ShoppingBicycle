package com.hoangbuix.bicycle.service.Impl;

import com.hoangbuix.bicycle.dao.OrderDAO;
import com.hoangbuix.bicycle.entity.OrderEntity;
import com.hoangbuix.bicycle.exception.NotFoundException;
import com.hoangbuix.bicycle.model.request.create.CreateOrderReq;
import com.hoangbuix.bicycle.model.request.update.UpdateOrderReq;
import com.hoangbuix.bicycle.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDAO<OrderEntity> orderDAO;

    @Override
    public int save(CreateOrderReq req) {
        int id = 0;
        try {
            OrderEntity order = new OrderEntity();
            order.setNote(req.getNote());
            order.setProductPrice(req.getProductPrice());
            order.setPromotionId(req.getPromotionId());
            order.setProductId(req.getProductId());
            order.setProductSize(req.getProductSize());
            order.setReceiverName(req.getReceiverName());
            order.setReceiverAddress(req.getReceiverAddress());
            order.setReceiverPhone(req.getReceiverPhone());
            order.setStatus(req.getStatus());
            order.setTotalPrice(req.getTotalPrice());
            order.setBuyer(req.getBuyer());
            order.setCreatedBy(req.getCreatedBy());
            order.setModifiedBy(req.getModifiedBy());
            id = orderDAO.save(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public void update(UpdateOrderReq req) {
        try {
            OrderEntity order = new OrderEntity();
            order.setNote(req.getNote());
            order.setProductPrice(req.getProductPrice());
            order.setPromotionId(req.getPromotionId());
            order.setProductId(req.getProductId());
            order.setProductSize(req.getProductSize());
            order.setReceiverName(req.getReceiverName());
            order.setReceiverAddress(req.getReceiverAddress());
            order.setReceiverPhone(req.getReceiverPhone());
            order.setStatus(req.getStatus());
            order.setTotalPrice(req.getTotalPrice());
            order.setBuyer(req.getBuyer());
            order.setCreatedBy(req.getCreatedBy());
            order.setModifiedBy(req.getModifiedBy());
            order.setActiveFlag(req.getActiveFlag());
            orderDAO.save(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            orderDAO.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OrderEntity> findAll() {
        List<OrderEntity> order = orderDAO.findAll();
        if (order.isEmpty()) {
            throw new NotFoundException("Kg");
        }
        return order;
    }

    @Override
    public OrderEntity findById(int id) {
        OrderEntity order = orderDAO.findById(id);
        if (order == null) {
            throw new NotFoundException("");
        }
        return order;
    }
}
