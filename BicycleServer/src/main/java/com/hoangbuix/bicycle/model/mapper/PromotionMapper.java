package com.hoangbuix.bicycle.model.mapper;


import com.hoangbuix.bicycle.entity.PromotionEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PromotionMapper implements RowMapper<PromotionEntity> {
    @Override
    public PromotionEntity mapRow(ResultSet resultSet) {
        try {
            PromotionEntity promotion = new PromotionEntity();
            promotion.setId(resultSet.getInt("id"));
            return promotion;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
