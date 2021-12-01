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
        return brandDAO.save(brand);
    }

    @Override
    public void update(BrandEntity brand) {
        brandDAO.update(brand);
    }

    @Override
    public void delete(int id) {
        brandDAO.delete(id);
    }

    @Override
    public List<BrandEntity> findAll() {
        return brandDAO.findAll();
    }

    @Override
    public BrandEntity findById(int id) {
        return brandDAO.findById(id);
    }
}
