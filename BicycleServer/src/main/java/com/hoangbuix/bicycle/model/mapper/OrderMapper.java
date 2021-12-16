package com.hoangbuix.bicycle.model.mapper;


import com.hoangbuix.bicycle.entity.OrderEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<OrderEntity> {
    @Override
    public OrderEntity mapRow(ResultSet resultSet) {
        try {
            OrderEntity order = new OrderEntity();
            order.setId(resultSet.getInt("id"));
            return order;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
