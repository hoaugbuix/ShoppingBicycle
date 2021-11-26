package com.hoangbuix.bicycle.dao.impl;

import com.hoangbuix.bicycle.dao.CategoryDAO;
import com.hoangbuix.bicycle.entity.CategoryEntity;
import com.hoangbuix.bicycle.model.mapper.CategoryMapper;
import com.hoangbuix.bicycle.util.QueryConstant;
import com.hoangbuix.bicycle.util.SqlConstant;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional(rollbackFor = Exception.class)
public class CategoryDAOImpl extends BaseDAOImpl<CategoryEntity> implements CategoryDAO<CategoryEntity> {
    final Logger log = Logger.getLogger(CategoryDAOImpl.class);
    private final String CATEGORY = "category";

    @Override
    public int save(CategoryEntity category) {
        return insert(QueryConstant.callQuery(CATEGORY, SqlConstant.CREATE, category.getCategoryName(),
                category.getCategoryCode(), category.getDescription()), category.getCategoryName(),
                category.getCategoryCode(), category.getDescription());
    }

    @Override
    public void update(CategoryEntity category) {
        update(QueryConstant.callQuery(CATEGORY, SqlConstant.UPDATE, category.getCategoryName(),
                category.getCategoryCode(), category.getDescription()), category.getCategoryName(),
                category.getCategoryCode(), category.getDescription());
    }

    @Override
    public void delete(int id) {
        delete(QueryConstant.callQuery(CATEGORY, SqlConstant.DELETE, id), id);
    }

    @Override
    public List<CategoryEntity> findAll() {
        log.info("find All");
        return query(QueryConstant.callQuery(CATEGORY, SqlConstant.FIND_ALL, null),
                new CategoryMapper());
    }

    @Override
    public CategoryEntity findById(int id) {
        List<CategoryEntity> category = query(QueryConstant.callQuery(CATEGORY, SqlConstant.FIND_BY_ID, id), new CategoryMapper(), id);
        return category.isEmpty() ? null : category.get(0);
    }
}
