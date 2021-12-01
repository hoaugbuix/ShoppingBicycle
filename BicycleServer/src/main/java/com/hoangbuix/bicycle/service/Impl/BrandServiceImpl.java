package com.hoangbuix.bicycle.service.Impl;

import com.hoangbuix.bicycle.entity.BrandEntity;
import com.hoangbuix.bicycle.service.BrandService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BrandServiceImpl implements BrandService {
    @Override
    public int save(BrandEntity instance) {
        return 0;
    }

    @Override
    public void update(BrandEntity instance) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<BrandEntity> findAll() {
        return null;
    }

    @Override
    public BrandEntity findById(int id) {
        return null;
    }
}
