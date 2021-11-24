package com.hoangbuix.bicycle.model.mapper;

import com.hoangbuix.bicycle.entity.ImageEntity;
import com.hoangbuix.bicycle.entity.RoleEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ImageMapper implements RowMapper<ImageEntity> {
    @Override
    public ImageEntity mapRow(ResultSet resultSet) {
        try {
            ImageEntity image = new ImageEntity();
            image.setId(resultSet.getInt("id"));
            image.setLink(resultSet.getString("link"));
            image.setFileName(resultSet.getString("file_name"));
            image.setSize(resultSet.getLong("size"));
            image.setFileType(resultSet.getString("file_type"));
            image.setPostId(resultSet.getLong("post_id"));
            image.setUploadBy(resultSet.getLong("upload_by"));
            image.setActiveFlag(resultSet.getInt("active_flag"));
            image.setCreatedDate(resultSet.getDate("created_date"));
            image.setUpdatedDate(resultSet.getDate("updated_date"));
            return image;
        } catch (SQLException e) {
            return null;
        }
    }
}