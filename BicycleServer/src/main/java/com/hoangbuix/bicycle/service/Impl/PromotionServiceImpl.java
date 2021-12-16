package com.hoangbuix.bicycle.service.Impl;

import com.hoangbuix.bicycle.dao.PromotionDAO;
import com.hoangbuix.bicycle.entity.PromotionEntity;
import com.hoangbuix.bicycle.model.request.create.CreatePromotionReq;
import com.hoangbuix.bicycle.model.request.update.UpdatePromotionReq;
import com.hoangbuix.bicycle.service.PromotionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PromotionServiceImpl implements PromotionService {
    final Logger log = Logger.getLogger(PromotionServiceImpl.class);

    @Autowired
    private PromotionDAO<PromotionEntity> promotionDAO;

    @Override
    public int save(CreatePromotionReq req) {
        int id = 0;
        try {
            PromotionEntity pro = new PromotionEntity();
            pro.setName(req.getName());
            pro.setCouponCode(req.getCouponCode());
            pro.setDiscountType(req.getDiscountType());
            pro.setDiscountValue(req.getDiscountValue());
            pro.setMaximumDiscountValue(req.getMaximumDiscountValue());
            if (req.getIsActive() == 1) {
                pro.setActive(true);
            }
            if (req.getIsPublic() == 1) {
                pro.setPublic(true);
            }
            if (req.getIsActive() == 0) {
                pro.setActive(false);
            }
            if (req.getIsPublic() == 0) {
                pro.setPublic(false);
            }
            id = promotionDAO.save(pro);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return id;
    }

    @Override
    public void update(UpdatePromotionReq req) {
        try {
            PromotionEntity pro = new PromotionEntity();
            pro.setName(req.getName());
            pro.setCouponCode(req.getCouponCode());
            pro.setDiscountType(req.getDiscountType());
            pro.setDiscountValue(req.getDiscountValue());
            pro.setMaximumDiscountValue(req.getMaximumDiscountValue());
            if (req.getIsActive() == 1) {
                pro.setActive(true);
            }
            if (req.getIsPublic() == 1) {
                pro.setPublic(true);
            }
            if (req.getIsActive() == 0) {
                pro.setActive(false);
            }
            if (req.getIsPublic() == 0) {
                pro.setPublic(false);
            }
            pro.setActiveFlag(req.getActiveFlag());
            promotionDAO.update(pro);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try {
            promotionDAO.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    @Override
    public List<PromotionEntity> findAll() {
        log.info("find all");
        List<PromotionEntity> lstPro = null;
        try {
            lstPro = promotionDAO.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return lstPro;
    }

    @Override
    public PromotionEntity findById(int id) {
        PromotionEntity pro = null;
        try {
            pro = promotionDAO.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return pro;
    }

    @Override
    public PromotionEntity findByCouponCode(String couponCode) {
        PromotionEntity pro = null;
        try {
            pro = promotionDAO.findByCouponCode(couponCode);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return pro;
    }
}
