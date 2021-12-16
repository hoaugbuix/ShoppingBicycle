package com.hoangbuix.bicycle.dao.impl;

import com.hoangbuix.bicycle.dao.PromotionDAO;
import com.hoangbuix.bicycle.entity.PromotionEntity;
import com.hoangbuix.bicycle.model.mapper.PromotionMapper;
import com.hoangbuix.bicycle.util.QueryConstant;
import com.hoangbuix.bicycle.util.SqlConstant;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional(rollbackFor = Exception.class)
public class PromotionDAOImpl extends BaseDAOImpl<PromotionEntity> implements PromotionDAO<PromotionEntity> {
    final Logger log = Logger.getLogger(PromotionDAOImpl.class);
    private final String PROMOTION = "promotion";

    @Override
    public int save(PromotionEntity promotion) {
        return insert(QueryConstant.callQuery(PROMOTION, SqlConstant.CREATE, promotion.getName(), promotion.getCouponCode(), promotion.getDiscountType(), promotion.getDiscountValue(),
                promotion.getMaximumDiscountValue(), promotion.isActive(), promotion.isPublic()), promotion.getName(), promotion.getCouponCode(), promotion.getDiscountType(), promotion.getDiscountValue(),
                promotion.getMaximumDiscountValue(), promotion.isActive(), promotion.isPublic());
    }

    @Override
    public void update(PromotionEntity promotion) {
        update(QueryConstant.callQuery(PROMOTION, SqlConstant.UPDATE, promotion.getName(), promotion.getCouponCode(), promotion.getDiscountType(), promotion.getDiscountValue(),
                promotion.getMaximumDiscountValue(), promotion.isActive(), promotion.isPublic(), promotion.getActiveFlag()), promotion.getName(), promotion.getCouponCode(),
                promotion.getDiscountType(), promotion.getDiscountValue(),
                promotion.getMaximumDiscountValue(), promotion.isActive(), promotion.isPublic(), promotion.getActiveFlag());
    }

    @Override
    public void delete(int id) {
        delete(QueryConstant.callQuery(PROMOTION, SqlConstant.DELETE, id), id);
    }

    @Override
    public List<PromotionEntity> findAll() {
        log.info("find All");
        return query(QueryConstant.callQuery(PROMOTION, SqlConstant.FIND_ALL, null),
                new PromotionMapper());
    }

    @Override
    public PromotionEntity findById(int id) {
        List<PromotionEntity> promotion = query(QueryConstant.callQuery(PROMOTION, SqlConstant.FIND_BY_ID, id), new PromotionMapper(), id);
        return promotion.isEmpty() ? null : promotion.get(0);
    }

    @Override
    public PromotionEntity findByCouponCode(String couponCode) {
        List<PromotionEntity> promotion = query(QueryConstant.callQuery(PROMOTION, SqlConstant.FIND_BY_ID, couponCode), new PromotionMapper(), couponCode);
        return promotion.isEmpty() ? null : promotion.get(0);
    }
}
