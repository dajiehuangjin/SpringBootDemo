package com.wq.springboot.service;

import java.io.Serializable;
import java.util.List;

import com.wq.springboot.common.mapper.BaseMapper;

public interface BaseService<M extends BaseMapper, T extends Serializable, PK extends Serializable> {

    T getById(M mapper, PK id);
    List<T> getAllList(M mapper, String orderBy);
    List<T> getByRangeList(M mapper, int pageNo, int pageSize, String orderBy);

    int count(M mapper);

    void insert(M mapper, T o);

    void update(M mapper, T o);

    void delete(M mapper, T o);
    void deleteById(M mapper, PK id);
}
