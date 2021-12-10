package com.hoangbuix.bicycle.service.Impl;

import com.hoangbuix.bicycle.dao.ProductSizeDAO;
import com.hoangbuix.bicycle.entity.ProductSizeEntity;
import com.hoangbuix.bicycle.exception.NotFoundException;
import com.hoangbuix.bicycle.model.request.create.CreateProductSizeReq;
import com.hoangbuix.bicycle.model.request.update.UpdateProductSizeReq;
import com.hoangbuix.bicycle.service.ProductSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductSizeServiceImpl implements ProductSizeService {
    @Autowired
    private ProductSizeDAO<ProductSizeEntity> productSizeDAO;

    @Override
    public int save(CreateProductSizeReq req) {
        int id = 0;
        try {
            ProductSizeEntity product = new ProductSizeEntity();
            product.setSize(req.getSize());
            product.setQuantity(req.getQuantity());
            id = productSizeDAO.save(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public void update(UpdateProductSizeReq req) {
        try {
            ProductSizeEntity product = new ProductSizeEntity();
            product.setSize(req.getSize());
            product.setQuantity(req.getQuantity());
            product.setActiveFlag(req.getActiveFlag());
            productSizeDAO.save(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            productSizeDAO.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ProductSizeEntity> findAll() {
        List<ProductSizeEntity> products = productSizeDAO.findAll();
        if (products.isEmpty()) {
            throw new NotFoundException("Kg");
        }
        return products;
    }

    @Override
    public ProductSizeEntity findById(int id) {
        ProductSizeEntity product = productSizeDAO.findById(id);
        if (product == null) {
            throw new NotFoundException("");
        }
        return product;
    }

    @Override
    public ProductSizeEntity findBySize(int size) {
        ProductSizeEntity product = productSizeDAO.findBySize(size);
        if (product == null) {
            throw new NotFoundException("");
        }
        return product;
    }

    @Override
    public ProductSizeEntity findByQuantity(int quantity) {
        ProductSizeEntity product = productSizeDAO.findBySize(quantity);
        if (product == null) {
            throw new NotFoundException("");
        }
        return product;
    }
}
