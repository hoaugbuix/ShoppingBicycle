package com.hoangbuix.bicycle.service.Impl;

import com.hoangbuix.bicycle.dao.CategoryDAO;
import com.hoangbuix.bicycle.entity.CategoryEntity;
import com.hoangbuix.bicycle.service.CategoryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryServiceImpl implements CategoryService {
    final Logger log = Logger.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryDAO<CategoryEntity> categoryDAO;

    @Override
    public int save(CategoryEntity cate) {
        int id = 0;
        try {
            id = categoryDAO.save(cate);
        } catch (Exception e) {
          e.printStackTrace();
          log.error(e.getMessage());
        }
        return id;
    }

    @Override
    public void update(CategoryEntity cate) {
        try {
            categoryDAO.update(cate);
        } catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try {
            categoryDAO.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    @Override
    public List<CategoryEntity> findAll() {
        log.info("find all");
        List<CategoryEntity> lstCate = null;
        try {
            lstCate = categoryDAO.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return lstCate;
    }

    @Override
    public CategoryEntity findById(int id) {
        CategoryEntity cate = null;
        try {
            cate = categoryDAO.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return cate;
    }
}
