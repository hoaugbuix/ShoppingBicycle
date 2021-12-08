package com.hoangbuix.bicycle.service;

import com.hoangbuix.bicycle.entity.ProductEntity;
import org.springframework.stereotype.Service;

@Service
public interface ProductService extends CommonService<ProductEntity> {
    ProductEntity findByProductName(String productName);
}
