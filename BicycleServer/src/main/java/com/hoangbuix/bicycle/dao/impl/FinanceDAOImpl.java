package com.hoangbuix.bicycle.dao.impl;

import com.hoangbuix.bicycle.dao.FinanceDAO;
import com.hoangbuix.bicycle.entity.FinanceEntity;
import com.hoangbuix.bicycle.model.mapper.FinanceMapper;
import com.hoangbuix.bicycle.util.QueryConstant;
import com.hoangbuix.bicycle.util.SqlConstant;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional(rollbackFor = Exception.class)
public class FinanceDAOImpl extends BaseDAOImpl<FinanceEntity> implements FinanceDAO<FinanceEntity> {
    private final String FINANCE = "finance";

    @Override
    public int save(FinanceEntity finance) {
        return insert(QueryConstant.callQuery(FINANCE, SqlConstant.CREATE, finance.getAmount(), finance.getOrderId()),
                finance.getAmount(), finance.getOrderId());
    }

    @Override
    public void update(FinanceEntity finance) {
        update(QueryConstant.callQuery(FINANCE, SqlConstant.UPDATE, finance.getAmount(), finance.getOrderId(), finance.getActiveFlag()),
                finance.getAmount(), finance.getOrderId(), finance.getActiveFlag());
    }

    @Override
    public void delete(int id) {
        delete(QueryConstant.callQuery(FINANCE, SqlConstant.DELETE, id), id);
    }

    @Override
    public List<FinanceEntity> findAll() {
        return query(QueryConstant.callQuery(FINANCE, SqlConstant.FIND_ALL, null),
                new FinanceMapper());
    }

    @Override
    public FinanceEntity findById(int id) {
        List<FinanceEntity> finance = query(QueryConstant.callQuery(FINANCE, SqlConstant.FIND_BY_ID, id), new FinanceMapper(), id);
        return finance.isEmpty() ? null : finance.get(0);
    }


    @Override
    public FinanceEntity findByAmount(int amount) {
        List<FinanceEntity> finance = query(QueryConstant.callQuery(FINANCE, SqlConstant.FIND_BY_, amount), new FinanceMapper(), amount);
        return finance.isEmpty() ? null : finance.get(0);
    }

}
