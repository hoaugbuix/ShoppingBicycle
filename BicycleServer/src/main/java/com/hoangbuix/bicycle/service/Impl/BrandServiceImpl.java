package com.hoangbuix.bicycle.service.Impl;

import com.hoangbuix.bicycle.dao.BrandDAO;
import com.hoangbuix.bicycle.entity.BrandEntity;
import com.hoangbuix.bicycle.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandDAO<BrandEntity> brandDAO;

    @Override
    public int save(BrandEntity brand) {
        int id = 0;
        try {
            id = brandDAO.save(brand);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
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
