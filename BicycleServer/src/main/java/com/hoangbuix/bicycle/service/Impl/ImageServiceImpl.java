package com.hoangbuix.bicycle.service.Impl;

import com.hoangbuix.bicycle.dao.ImageDAO;
import com.hoangbuix.bicycle.entity.ImageEntity;
import com.hoangbuix.bicycle.exception.BadRequestException;
import com.hoangbuix.bicycle.exception.InternalServerException;
import com.hoangbuix.bicycle.service.ImageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;

@Component
public class ImageServiceImpl implements ImageService {
    final Logger log = Logger.getLogger(ImageServiceImpl.class);
    @Autowired
    private ImageDAO<ImageEntity> imageDAO;

    @Override
    public ImageEntity saveImage(ImageEntity image) {
        log.info("save image" + image.toString());
//        ImageEntity newImage = new ImageEntity();
//        newImage.setLink(image.getLink());
//        newImage.setFileName(image.getFileName());
//        newImage.setFileType(image.getFileType());
//        newImage.setSize(image.getSize());
//        newImage.setPostId(image.getPostId());
//        newImage.setUploadBy(image.getUploadBy());
        int id = imageDAO.save(image);
        return imageDAO.findById(id);
    }


    @Override
    @Transactional(rollbackFor = InternalServerException.class)
    public void deleteImage(String uploadDir, String filename) {
        String link = "/media/static/" + filename;
//        ImageEntity img = imageRepository.findByLink(link);
        ImageEntity img = null;
        if (img == null) {
            throw new BadRequestException("File không tồn tại");
        }

//        Integer inUse = imageRepository.checkImgInUse(link);
        Integer inUse = null;
        if (inUse != null) {
            throw new BadRequestException("Ảnh đã được sử dụng không thể xóa");
        }

//        imageDAO.delete(img);

        File file = new File(uploadDir + "/" + filename);
        if (file.exists()) {
            if (!file.delete()) {
                throw new InternalServerException("Lỗi khi xóa ảnh");
            }
        }
    }

}
