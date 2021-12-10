package com.hoangbuix.bicycle.dao.impl;

import com.hoangbuix.bicycle.dao.PostDAO;
import com.hoangbuix.bicycle.entity.PostEntity;
import com.hoangbuix.bicycle.model.mapper.PostMapper;
import com.hoangbuix.bicycle.util.QueryConstant;
import com.hoangbuix.bicycle.util.SqlConstant;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional(rollbackFor = Exception.class)
public class PostDAOImpl extends BaseDAOImpl<PostEntity> implements PostDAO<PostEntity> {
    final String POST = "post";

    @Override
    public int save(PostEntity post) {
        return insert(QueryConstant.callQuery(POST, SqlConstant.CREATE, post.getContent(), post.getTitle(), post.getSlug(),
                post.getThumbnail(), post.getDescription(), post.getCreatedBy(), post.getUpdatedBy()), post.getContent(), post.getTitle(), post.getSlug(),
                post.getThumbnail(), post.getDescription(), post.getCreatedBy(), post.getUpdatedBy());
    }

    @Override
    public void update(PostEntity post) {
        update(QueryConstant.callQuery(POST, SqlConstant.UPDATE,
                post.getContent(), post.getTitle(), post.getSlug(),
                post.getThumbnail(), post.getDescription(), post.getUpdatedBy(), post.getActiveFlag()),
                post.getContent(), post.getTitle(), post.getSlug(),
                post.getThumbnail(), post.getDescription(), post.getUpdatedBy(), post.getActiveFlag());
    }

    @Override
    public void delete(int id) {
        delete(QueryConstant.callQuery(POST, SqlConstant.DELETE, id), id);
    }

    @Override
    public List<PostEntity> findAll() {
        return query(QueryConstant.callQuery(POST, SqlConstant.FIND_ALL, null),
                new PostMapper());
    }

    @Override
    public PostEntity findById(int id) {
        List<PostEntity> post = query(QueryConstant.callQuery(POST, SqlConstant.FIND_BY_ID, id), new PostMapper(), id);
        return post.isEmpty() ? null : post.get(0);
    }

    @Override
    public PostEntity findByTitle(String title) {
        List<PostEntity> post = query(QueryConstant.callQuery(POST, (SqlConstant.FIND_BY_ + "Title"), title), new PostMapper(), title);
        return post.isEmpty() ? null : post.get(0);
    }

    @Override
    public PostEntity findByContent(String content) {
        List<PostEntity> post = query(QueryConstant.callQuery(POST, (SqlConstant.FIND_BY_ + "Content"), content), new PostMapper(), content);
        return post.isEmpty() ? null : post.get(0);
    }
}
