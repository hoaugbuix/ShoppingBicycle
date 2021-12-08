package com.hoangbuix.bicycle.model.mapper;

import com.hoangbuix.bicycle.entity.BrandEntity;
import com.hoangbuix.bicycle.entity.PostEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostMapper implements RowMapper<PostEntity> {
    @Override
    public PostEntity mapRow(ResultSet resultSet) {
        try {
            PostEntity post = new PostEntity();
            post.setId(resultSet.getInt("id"));
            post.setContent(resultSet.getString("content"));
            post.setTitle(resultSet.getString("title"));
            post.setSlug(resultSet.getString("slug"));
            post.setThumbnail(resultSet.getString("thumbnail"));
            post.setDescription(resultSet.getString("description"));
            post.setCreatedBy(resultSet.getInt("created_by"));
            post.setUpdatedBy(resultSet.getInt("updated_by"));
            post.setActiveFlag(resultSet.getInt("active_flag"));
            post.setCreatedDate(resultSet.getDate("created_date"));
            post.setUpdatedDate(resultSet.getDate("updated_date"));
            return post;
        } catch (SQLException e) {
            return null;
        }
    }
}