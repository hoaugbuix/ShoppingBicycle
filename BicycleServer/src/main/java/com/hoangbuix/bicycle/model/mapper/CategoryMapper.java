package com.hoangbuix.bicycle.model.mapper;

import com.hoangbuix.bicycle.entity.CategoryEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper<CategoryEntity> {
    @Override
    public CategoryEntity mapRow(ResultSet resultSet) {
        try {
            CategoryEntity cate = new CategoryEntity();
            cate.setId(resultSet.getInt("id"));
            cate.setCategoryName(resultSet.getString("category_name"));
            cate.setCategoryCode(resultSet.getString("category_code"));
            cate.setDescription(resultSet.getString("description"));
            cate.setActiveFlag(resultSet.getInt("active_flag"));
            cate.setCreatedDate(resultSet.getDate("created_date"));
            cate.setUpdatedDate(resultSet.getDate("updated_date"));
            return cate;
        }catch (SQLException e){
            return null;
        }
    }
}
