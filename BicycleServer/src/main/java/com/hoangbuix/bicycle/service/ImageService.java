package com.hoangbuix.bicycle.service;

import com.hoangbuix.bicycle.entity.ImageEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface ImageService {
    ImageEntity saveImage(ImageEntity image);
    void deleteImage(String uploadDir, String filename);
}
