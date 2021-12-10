package com.hoangbuix.bicycle.model.mapper;


import com.hoangbuix.bicycle.entity.ProductSizeEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductSizeMapper implements RowMapper<ProductSizeEntity> {
    @Override
    public ProductSizeEntity mapRow(ResultSet resultSet) {
        try {
            ProductSizeEntity product = new ProductSizeEntity();
            product.setId(resultSet.getInt("id"));
            return product;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
