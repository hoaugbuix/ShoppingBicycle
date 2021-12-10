package com.hoangbuix.bicycle.model.mapper;


import com.hoangbuix.bicycle.entity.FinanceEntity;
import com.hoangbuix.bicycle.entity.ProductSizeEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FinanceMapper implements RowMapper<FinanceEntity> {
    @Override
    public FinanceEntity mapRow(ResultSet resultSet) {
        try {
            FinanceEntity finance = new FinanceEntity();
            finance.setId(resultSet.getInt("id"));
            return finance;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
