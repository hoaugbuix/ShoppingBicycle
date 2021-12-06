package com.hoangbuix.bicycle.service.Impl;

import com.hoangbuix.bicycle.dao.BrandDAO;
import com.hoangbuix.bicycle.dao.PostDAO;
import com.hoangbuix.bicycle.entity.BrandEntity;
import com.hoangbuix.bicycle.entity.PostEntity;
import com.hoangbuix.bicycle.entity.UserEntity;
import com.hoangbuix.bicycle.exception.NotFoundException;
import com.hoangbuix.bicycle.model.request.create.CreateBrandReq;
import com.hoangbuix.bicycle.model.request.create.CreatePostReq;
import com.hoangbuix.bicycle.model.request.update.UpdateBrandReq;
import com.hoangbuix.bicycle.model.request.update.UpdatePostReq;
import com.hoangbuix.bicycle.security.CustomUserDetails;
import com.hoangbuix.bicycle.service.BrandService;
import com.hoangbuix.bicycle.service.PostService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostServiceImpl implements PostService {
    final Logger log = Logger.getLogger(PostServiceImpl.class);

    @Autowired
    private PostDAO<PostEntity> postDAO;

    @Override
    public int save(CreatePostReq req) {
        PostEntity post = postDAO.findByTitle(req.getTitle());
        UserEntity user = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
        PostEntity postNew = new PostEntity();
        if (post == null) {
            postNew.setContent(req.getContent());
            postNew.setTitle(req.getTitle());
            postNew.setSlug(req.getSlug());
            postNew.setThumbnail(req.getThumbnail());
            postNew.setDescription(req.getDescription());
            postNew.setCreatedBy(user.getId());
            postNew.setUpdatedBy(user.getId());
        }
        return postDAO.save(postNew);
    }

    @Override
    public void update(UpdatePostReq req, int id) {
        try {
            UserEntity user = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
            PostEntity post = postDAO.findByTitle(req.getTitle());
            PostEntity postNew = new PostEntity();
            if (post == null) {
                postNew.setContent(req.getContent());
                postNew.setTitle(req.getTitle());
                postNew.setSlug(req.getSlug());
                postNew.setThumbnail(req.getThumbnail());
                postNew.setDescription(req.getDescription());
                postNew.setUpdatedBy(user.getId());
                postNew.setActiveFlag(req.getActiveFlag());
                postDAO.update(postNew);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        PostEntity post = postDAO.findById(id);
        if (post == null) {
            throw new NotFoundException("No find ID!");
        }
        postDAO.delete(id);
    }

    @Override
    public List<PostEntity> findAll() {
        return postDAO.findAll();
    }

    @Override
    public PostEntity findById(int id) {
        return postDAO.findById(id);
    }

    @Override
    public PostEntity findByTitle(String title) {
        return postDAO.findByTitle(title);
    }

    @Override
    public PostEntity findByContent(String content) {
        return postDAO.findByContent(content);
    }

}
