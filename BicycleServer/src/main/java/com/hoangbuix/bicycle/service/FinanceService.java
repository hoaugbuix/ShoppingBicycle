package com.hoangbuix.bicycle.service;

import com.hoangbuix.bicycle.entity.FinanceEntity;
import com.hoangbuix.bicycle.entity.ProductSizeEntity;
import com.hoangbuix.bicycle.model.request.create.CreateFinanceReq;
import com.hoangbuix.bicycle.model.request.create.CreateProductSizeReq;
import com.hoangbuix.bicycle.model.request.update.UpdateFinanceReq;
import com.hoangbuix.bicycle.model.request.update.UpdateProductSizeReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FinanceService {
    int save(CreateFinanceReq instance);

    void update(UpdateFinanceReq instance);

    void delete(int id);

    List<FinanceEntity> findAll();

    FinanceEntity findById(int id);

    FinanceEntity findByAmount(int amount);

//    ProductSizeEntity findByQuantity(int quantity);
}
