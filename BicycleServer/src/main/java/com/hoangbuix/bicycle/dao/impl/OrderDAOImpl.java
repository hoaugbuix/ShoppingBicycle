package com.hoangbuix.bicycle.dao.impl;

import com.hoangbuix.bicycle.dao.OrderDAO;
import com.hoangbuix.bicycle.entity.OrderEntity;
import com.hoangbuix.bicycle.model.mapper.OrderMapper;
import com.hoangbuix.bicycle.util.QueryConstant;
import com.hoangbuix.bicycle.util.SqlConstant;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional(rollbackFor = Exception.class)
public class OrderDAOImpl extends BaseDAOImpl<OrderEntity> implements OrderDAO<OrderEntity> {
    final Logger log = Logger.getLogger(OrderDAOImpl.class);
    private final String ORDER = "order";

    @Override
    public int save(OrderEntity order) {
        return insert(QueryConstant.callQuery(ORDER, SqlConstant.CREATE, order.getNote(), order.getProductPrice(), order.getPromotionId(),
                order.getProductSize(), order.getProductId(), order.getReceiverName(), order.getReceiverAddress(), order.getReceiverPhone(), order.getStatus(),
                order.getTotalPrice(), order.getBuyer(), order.getCreatedBy(), order.getModifiedBy()), order.getNote(), order.getProductPrice(), order.getPromotionId(),
                order.getProductSize(), order.getProductId(), order.getReceiverName(), order.getReceiverAddress(), order.getReceiverPhone(), order.getStatus(),
                order.getTotalPrice(), order.getBuyer(), order.getCreatedBy(), order.getModifiedBy());
    }

    @Override
    public void update(OrderEntity order) {
        update(QueryConstant.callQuery(ORDER, SqlConstant.UPDATE, order.getNote(), order.getProductPrice(), order.getPromotionId(),
                order.getProductSize(), order.getProductId(), order.getReceiverName(), order.getReceiverAddress(), order.getReceiverPhone(), order.getStatus(),
                order.getTotalPrice(), order.getBuyer(), order.getCreatedBy(), order.getModifiedBy(), order.getActiveFlag()), order.getNote(), order.getProductPrice(), order.getPromotionId(),
                order.getProductSize(), order.getProductId(), order.getReceiverName(), order.getReceiverAddress(), order.getReceiverPhone(), order.getStatus(),
                order.getTotalPrice(), order.getBuyer(), order.getCreatedBy(), order.getModifiedBy(), order.getActiveFlag());
    }

    @Override
    public void delete(int id) {
        delete(QueryConstant.callQuery(ORDER, SqlConstant.DELETE, id), id);
    }

    @Override
    public List<OrderEntity> findAll() {
        log.info("find All");
        return query(QueryConstant.callQuery(ORDER, SqlConstant.FIND_ALL, null),
                new OrderMapper());
    }

    @Override
    public OrderEntity findById(int id) {
        List<OrderEntity> order = query(QueryConstant.callQuery(ORDER, SqlConstant.FIND_BY_ID, id), new OrderMapper(), id);
        return order.isEmpty() ? null : order.get(0);
    }

    @Override
    public OrderEntity findByStatusAndProductId(String status, int productId) {
        List<OrderEntity> order = query(QueryConstant.callQuery(ORDER, SqlConstant.FIND_BY_STATUS_AND_PRODUCT_ID, status, productId), new OrderMapper(), status, productId);
        return order.isEmpty() ? null : order.get(0);
    }
}
