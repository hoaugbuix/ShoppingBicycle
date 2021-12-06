package com.hoangbuix.bicycle.model.mapper;

import com.hoangbuix.bicycle.entity.EmailEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmailMapper implements RowMapper<EmailEntity> {
    @Override
    public EmailEntity mapRow(ResultSet resultSet) {
        try {
            EmailEntity email = new EmailEntity();
            email.setId(resultSet.getInt("id"));
            email.setContentEmail(resultSet.getString("content_email"));
            email.setSeen(resultSet.getLong("seen"));
            email.setActiveFlag(resultSet.getInt("active_flag"));
            email.setCreatedDate(resultSet.getDate("created_date"));
            email.setUpdatedDate(resultSet.getDate("updated_date"));
            return email;
        } catch (SQLException e) {
            return null;
        }
    }
}