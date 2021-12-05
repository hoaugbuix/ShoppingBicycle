package com.hoangbuix.bicycle.dao.impl;

import com.hoangbuix.bicycle.dao.BrandDAO;
import com.hoangbuix.bicycle.entity.BrandEntity;
import com.hoangbuix.bicycle.model.mapper.BrandMapper;
import com.hoangbuix.bicycle.util.QueryConstant;
import com.hoangbuix.bicycle.util.SqlConstant;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional(rollbackFor = Exception.class)
public class BrandDAOImpl extends BaseDAOImpl<BrandEntity> implements BrandDAO<BrandEntity> {
    final String BRAND = "brand";

    @Override
    public int save(BrandEntity brand) {
        return insert(QueryConstant.callQuery(BRAND, SqlConstant.CREATE, brand.getBrandName(), brand.getThumbnail()), brand.getBrandName(), brand.getThumbnail());
    }

    @Override
    public void update(BrandEntity brand) {
        update(QueryConstant.callQuery(BRAND, SqlConstant.UPDATE, brand.getId(),
                brand.getBrandName(), brand.getThumbnail(), brand.getActiveFlag()),
                brand.getId(), brand.getBrandName(), brand.getThumbnail(), brand.getActiveFlag());
    }

    @Override
    public void delete(int id) {
        delete(QueryConstant.callQuery(BRAND, SqlConstant.DELETE, id), id);
    }

    @Override
    public List<BrandEntity> findAll() {
        return query(QueryConstant.callQuery(BRAND, SqlConstant.FIND_ALL, null),
                new BrandMapper());
    }

    @Override
    public BrandEntity findById(int id) {
        List<BrandEntity> brand = query(QueryConstant.callQuery(BRAND, SqlConstant.FIND_BY_ID, id), new BrandMapper(), id);
        return brand.isEmpty() ? null : brand.get(0);
    }

    @Override
    public BrandEntity findByBrandName(String brandName) {
        List<BrandEntity> brand = query(QueryConstant.callQuery(BRAND, (SqlConstant.FIND_BY_ + "BrandName"), brandName),
                new BrandMapper(), brandName);
        return brand.isEmpty() ? null : brand.get(0);
    }
}
