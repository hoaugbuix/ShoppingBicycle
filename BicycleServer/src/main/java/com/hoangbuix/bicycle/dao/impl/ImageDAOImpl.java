package com.hoangbuix.bicycle.dao.impl;

import com.hoangbuix.bicycle.dao.ImageDAO;
import com.hoangbuix.bicycle.entity.ImageEntity;
import com.hoangbuix.bicycle.entity.UserEntity;
import com.hoangbuix.bicycle.model.mapper.ImageMapper;
import com.hoangbuix.bicycle.model.mapper.UserMapper;
import com.hoangbuix.bicycle.util.QueryConstant;
import com.hoangbuix.bicycle.util.SqlConstant;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.hoangbuix.bicycle.util.SqlConstant.FIND_BY_ID;

@Component
@Transactional(rollbackFor = Exception.class)
public class ImageDAOImpl extends BaseDAOImpl<ImageEntity> implements ImageDAO<ImageEntity> {
    final Logger log = Logger.getLogger(ImageDAOImpl.class);
    final String IMAGE = "image";

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int save(ImageEntity image) {
        log.info("ImageDAOImpl save" + image.toString());
        return insert(QueryConstant.callQuery(IMAGE, SqlConstant.CREATE, image.getLink(), image.getFileName(), image.getSize(),
                image.getFileType(), image.getPostId(), image.getUploadBy()), image.getLink(), image.getFileName(),image.getFileType(),
                image.getSize(), image.getPostId(), image.getUploadBy());
    }

    @Override
    public void update(ImageEntity instance) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<ImageEntity> findAll() {
        return null;
    }

    @Override
    public ImageEntity findById(int id) {
        List<ImageEntity> images = query(QueryConstant.callQuery(IMAGE, FIND_BY_ID, id),
                new ImageMapper(), id);
        return images.isEmpty() ? null : images.get(0);
    }
}
