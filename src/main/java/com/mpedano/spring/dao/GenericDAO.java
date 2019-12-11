package com.mpedano.spring.dao;

import com.mpedano.spring.model.User;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {
    public List<T> listAll();

    public void add(T entity);

    public void update(T entity);

    public void delete(ID id);

    public T findById(ID id);
}
