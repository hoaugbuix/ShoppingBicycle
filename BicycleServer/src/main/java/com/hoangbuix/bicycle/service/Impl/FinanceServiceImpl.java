package com.hoangbuix.bicycle.service.Impl;

import com.hoangbuix.bicycle.dao.FinanceDAO;
import com.hoangbuix.bicycle.entity.FinanceEntity;
import com.hoangbuix.bicycle.exception.NotFoundException;
import com.hoangbuix.bicycle.model.request.create.CreateFinanceReq;
import com.hoangbuix.bicycle.model.request.update.UpdateFinanceReq;
import com.hoangbuix.bicycle.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FinanceServiceImpl implements FinanceService {
    @Autowired
    private FinanceDAO<FinanceEntity> financeDAO;

    @Override
    public int save(CreateFinanceReq req) {
        int id = 0;
        try {
            FinanceEntity finance = new FinanceEntity();
            finance.setAmount(req.getAmount());
            finance.setOrderId(req.getOrderId());
            id = financeDAO.save(finance);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public void update(UpdateFinanceReq req) {
        try {
            FinanceEntity finance = new FinanceEntity();
            finance.setAmount(req.getAmount());
            finance.setOrderId(req.getOrderId());
            finance.setActiveFlag(req.getActiveFlag());
            financeDAO.save(finance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            financeDAO.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<FinanceEntity> findAll() {
        List<FinanceEntity> finance = financeDAO.findAll();
        if (finance.isEmpty()) {
            throw new NotFoundException("Kg");
        }
        return finance;
    }

    @Override
    public FinanceEntity findById(int id) {
        FinanceEntity finance = financeDAO.findById(id);
        if (finance == null) {
            throw new NotFoundException("");
        }
        return finance;
    }

    @Override
    public FinanceEntity findByAmount(int size) {
        FinanceEntity finance = financeDAO.findByAmount(size);
        if (finance == null) {
            throw new NotFoundException("");
        }
        return finance;
    }

}
