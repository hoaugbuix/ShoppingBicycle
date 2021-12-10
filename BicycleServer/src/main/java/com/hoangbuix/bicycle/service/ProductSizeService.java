package com.hoangbuix.bicycle.service;

import com.hoangbuix.bicycle.entity.ProductSizeEntity;
import com.hoangbuix.bicycle.model.request.create.CreateProductSizeReq;
import com.hoangbuix.bicycle.model.request.update.UpdateProductSizeReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductSizeService {
    int save(CreateProductSizeReq instance);

    void update(UpdateProductSizeReq instance);

    void delete(int id);

    List<ProductSizeEntity> findAll();

    ProductSizeEntity findById(int id);

    ProductSizeEntity findBySize(int size);

    ProductSizeEntity findByQuantity(int quantity);
}
