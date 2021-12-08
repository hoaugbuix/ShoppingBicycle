package com.hoangbuix.bicycle.service;

import com.hoangbuix.bicycle.entity.BrandEntity;
import com.hoangbuix.bicycle.entity.PostEntity;
import com.hoangbuix.bicycle.model.request.create.CreateBrandReq;
import com.hoangbuix.bicycle.model.request.create.CreatePostReq;
import com.hoangbuix.bicycle.model.request.update.UpdateBrandReq;
import com.hoangbuix.bicycle.model.request.update.UpdatePostReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    int save(CreatePostReq instance);

    void update(UpdatePostReq instance, int id);

    void delete(int id);

    List<PostEntity> findAll();

    PostEntity findById(int id);

    PostEntity findByTitle(String title);

    PostEntity findByContent(String content);
}
