package com.hoangbuix.bicycle.model.mapper;


import com.hoangbuix.bicycle.entity.ProductEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<ProductEntity> {
    @Override
    public ProductEntity mapRow(ResultSet resultSet) {
        try {
            ProductEntity product = new ProductEntity();
            product.setId(resultSet.getInt("id"));
            return product;
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
