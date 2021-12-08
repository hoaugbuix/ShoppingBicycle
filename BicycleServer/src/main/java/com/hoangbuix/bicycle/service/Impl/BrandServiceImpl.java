package com.hoangbuix.bicycle.service.Impl;

import com.hoangbuix.bicycle.dao.BrandDAO;
import com.hoangbuix.bicycle.entity.BrandEntity;
import com.hoangbuix.bicycle.exception.NotFoundException;
import com.hoangbuix.bicycle.model.request.create.CreateBrandReq;
import com.hoangbuix.bicycle.model.request.update.UpdateBrandReq;
import com.hoangbuix.bicycle.service.BrandService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BrandServiceImpl implements BrandService {
    final Logger log = Logger.getLogger(BrandServiceImpl.class);

    @Autowired
    private BrandDAO<BrandEntity> brandDAO;

    @Override
    public int save(CreateBrandReq brand) {
        BrandEntity brands = brandDAO.findByBrandName(brand.getBrandName());
        BrandEntity brandNew = new BrandEntity();
        if (brands == null) {
            brandNew.setBrandName(brand.getBrandName());
            brandNew.setThumbnail(brand.getThumbnail());
        }
        return brandDAO.save(brandNew);
    }

    @Override
    public void update(UpdateBrandReq brand, int id) {
        try {
            BrandEntity brands = brandDAO.findByBrandName(brand.getBrandName());
            BrandEntity brandNew = new BrandEntity();
            if (brands == null) {
                brandNew.setId(id);
                brandNew.setBrandName(brand.getBrandName());
                brandNew.setThumbnail(brand.getThumbnail());
                brandNew.setActiveFlag(brand.getActiveFlag());
                brandDAO.update(brandNew);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        BrandEntity brand = brandDAO.findById(id);
        if (brand == null) {
            throw new NotFoundException("No find ID!");
        }
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

    @Override
    public BrandEntity findByBrandName(String brandName) {
        return null;
    }
}