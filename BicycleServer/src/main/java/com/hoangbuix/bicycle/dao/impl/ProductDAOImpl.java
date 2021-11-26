package com.hoangbuix.bicycle.dao.impl;

import com.hoangbuix.bicycle.dao.ProductionDAO;
import com.hoangbuix.bicycle.entity.ProductEntity;
import com.hoangbuix.bicycle.model.mapper.ProductMapper;
import com.hoangbuix.bicycle.util.QueryConstant;
import com.hoangbuix.bicycle.util.SqlConstant;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional(rollbackFor = Exception.class)
public class ProductDAOImpl extends BaseDAOImpl<ProductEntity> implements ProductionDAO<ProductEntity> {
    private final String PRODUCT = "product";

    @Override
    public int save(ProductEntity product) {
        return insert(QueryConstant.callQuery(PRODUCT, SqlConstant.CREATE, product.getProductName(), product.getProductCode(),
                product.getDescription(), product.getSlug(), product.getBrandId(), product.getPrice(),
                product.getProductImage(), product.getTotalSold(), product.getCategoyId()), product.getProductName(), product.getProductCode(),
                product.getDescription(), product.getSlug(), product.getBrandId(), product.getPrice(),
                product.getProductImage(), product.getTotalSold(), product.getCategoyId());
    }

    @Override
    public void update(ProductEntity product) {
        update(QueryConstant.callQuery(PRODUCT, SqlConstant.UPDATE, product.getProductName(), product.getProductCode(),
                product.getDescription(), product.getSlug(), product.getBrandId(), product.getPrice(),
                product.getProductImage(), product.getTotalSold(), product.getCategoyId()), product.getProductName(), product.getProductCode(),
                product.getDescription(), product.getSlug(), product.getBrandId(), product.getPrice(),
                product.getProductImage(), product.getTotalSold(), product.getCategoyId());
    }

    @Override
    public void delete(int id) {
        delete(QueryConstant.callQuery(PRODUCT, SqlConstant.DELETE, id), id);
    }

    @Override
    public List<ProductEntity> findAll() {
        return query(QueryConstant.callQuery(PRODUCT, SqlConstant.FIND_ALL, null),
                new ProductMapper());
    }

    @Override
    public ProductEntity findById(int id) {
        List<ProductEntity> product = query(QueryConstant.callQuery(PRODUCT, SqlConstant.FIND_BY_ID, id), new ProductMapper(), id);
        return product.isEmpty() ? null : product.get(0);
    }
}
