package com.hoangbuix.bicycle.service.Impl;

import com.hoangbuix.bicycle.dao.ProductDAO;
import com.hoangbuix.bicycle.entity.ProductEntity;
import com.hoangbuix.bicycle.exception.NotFoundException;
import com.hoangbuix.bicycle.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDAO<ProductEntity> productDAO;

    @Override
    public int save(ProductEntity product) {
        int id = 0;
        try {
           id = productDAO.save(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public void update(ProductEntity product) {
        try {
            productDAO.save(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            productDAO.delete(id);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ProductEntity> findAll() {
        List<ProductEntity> products = productDAO.findAll();
        if (products.isEmpty()){
            throw new NotFoundException("Kg");
        }
        return products;
    }

    @Override
    public ProductEntity findById(int id) {
        ProductEntity product = productDAO.findById(id);
        if (product == null) {
            throw new NotFoundException("");
        }
        return product;
    }

    @Override
    public ProductEntity findByProductName(String productName) {
        ProductEntity product = productDAO.findByProductName(productName);
        if (product == null) {
            throw new NotFoundException("");
        }
        return product;
    }
}
