package com.bycecle.bicycleserver.dao;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CommonDAO<E> extends BaseDAO<E> {
    int save(E instance);

    void update(E instance);

    void delete(int id);

    List<E> findAll();

    E findById(int id);
}
