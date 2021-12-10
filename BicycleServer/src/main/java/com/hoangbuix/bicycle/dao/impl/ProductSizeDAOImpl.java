package com.hoangbuix.bicycle.dao.impl;

import com.hoangbuix.bicycle.dao.ProductSizeDAO;
import com.hoangbuix.bicycle.entity.ProductSizeEntity;
import com.hoangbuix.bicycle.model.mapper.ProductSizeMapper;
import com.hoangbuix.bicycle.util.QueryConstant;
import com.hoangbuix.bicycle.util.SqlConstant;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional(rollbackFor = Exception.class)
public class ProductSizeDAOImpl extends BaseDAOImpl<ProductSizeEntity> implements ProductSizeDAO<ProductSizeEntity> {
    private final String PRODUCT_SIZE = "productSize";

    @Override
    public int save(ProductSizeEntity product) {
        return insert(QueryConstant.callQuery(PRODUCT_SIZE, SqlConstant.CREATE, product.getSize(), product.getQuantity()), product.getSize(), product.getQuantity());
    }

    @Override
    public void update(ProductSizeEntity product) {
        update(QueryConstant.callQuery(PRODUCT_SIZE, SqlConstant.UPDATE, product.getSize(), product.getQuantity(), product.getActiveFlag()),
                product.getSize(), product.getQuantity(), product.getActiveFlag());
    }

    @Override
    public void delete(int id) {
        delete(QueryConstant.callQuery(PRODUCT_SIZE, SqlConstant.DELETE, id), id);
    }

    @Override
    public List<ProductSizeEntity> findAll() {
        return query(QueryConstant.callQuery(PRODUCT_SIZE, SqlConstant.FIND_ALL, null),
                new ProductSizeMapper());
    }

    @Override
    public ProductSizeEntity findById(int id) {
        List<ProductSizeEntity> product = query(QueryConstant.callQuery(PRODUCT_SIZE, SqlConstant.FIND_BY_ID, id), new ProductSizeMapper(), id);
        return product.isEmpty() ? null : product.get(0);
    }


    @Override
    public ProductSizeEntity findByQuantity(int quantity) {
        List<ProductSizeEntity> product = query(QueryConstant.callQuery(PRODUCT_SIZE, SqlConstant.FIND_BY_, quantity), new ProductSizeMapper(), quantity);
        return product.isEmpty() ? null : product.get(0);
    }

    @Override
    public ProductSizeEntity findBySize(int size) {
        List<ProductSizeEntity> product = query(QueryConstant.callQuery(PRODUCT_SIZE, SqlConstant.FIND_BY_, size), new ProductSizeMapper(), size);
        return product.isEmpty() ? null : product.get(0);
    }
}
