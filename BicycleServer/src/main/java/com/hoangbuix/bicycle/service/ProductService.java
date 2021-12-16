package com.hoangbuix.bicycle.service;

import com.hoangbuix.bicycle.entity.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    int save(ProductEntity instance);

    void update(ProductEntity instance);

    void delete(int id);

    List<ProductEntity> findAll();

    ProductEntity findById(int id);

    ProductEntity findByProductName(String productName);
}
