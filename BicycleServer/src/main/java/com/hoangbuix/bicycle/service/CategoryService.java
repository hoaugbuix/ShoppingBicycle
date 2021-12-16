package com.hoangbuix.bicycle.service;

import com.hoangbuix.bicycle.entity.CategoryEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    int save(CategoryEntity instance);

    void update(CategoryEntity instance);

    void delete(int id);

    List<CategoryEntity> findAll();

    CategoryEntity findById(int id);
}
