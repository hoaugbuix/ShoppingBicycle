package com.hoangbuix.bicycle.service;

import com.hoangbuix.bicycle.entity.BrandEntity;
import com.hoangbuix.bicycle.model.request.create.CreateBrandReq;
import com.hoangbuix.bicycle.model.request.update.UpdateBrandReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BrandService {
    int save(CreateBrandReq instance);

    void update(UpdateBrandReq instance, int id);

    void delete(int id);

    List<BrandEntity> findAll();

    BrandEntity findById(int id);

    BrandEntity findByBrandName(String brandName);
}
