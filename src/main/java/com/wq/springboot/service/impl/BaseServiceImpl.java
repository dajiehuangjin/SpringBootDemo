package com.wq.springboot.service.impl;

import com.wq.springboot.common.mapper.BaseMapper;
import com.wq.springboot.service.BaseService;
// import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
// import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class BaseServiceImpl<M extends BaseMapper, T extends Serializable, PK extends Serializable> implements BaseService<M, T, PK> {

    // private Class<T> entityClass;

    //@SuppressWarnings("unchecked")
    public BaseServiceImpl() {
        // ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        // entityClass = (Class<T>) type.getActualTypeArguments()[1];
    }

    @SuppressWarnings("unchecked")
    @Override
    public T getById(M mapper, PK id) {
        return (T) mapper.getById(id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> getAllList(M mapper, String orderBy) {
        if(orderBy != null && !orderBy.isEmpty()) {
            return mapper.getAllByOrder(orderBy);
        } else {
            return mapper.getAll();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> getByRangeList(M mapper, int pageNo, int pageSize, String orderBy) {
        if(orderBy != null && !orderBy.isEmpty()) {
            return mapper.getByRangeByOrder((pageNo - 1) * pageSize, pageSize, orderBy);
        } else {
            return mapper.getByRange((pageNo - 1) * pageSize, pageSize);
        }
    }

    @Override
    public int count(M mapper) {
        return mapper.getCount();
    }

    @Override
    public void insert(M mapper, T o) {
        mapper.insert(o);
    }

    @Override
    public void update(M mapper, T o) {
        mapper.update(o);
    }

    @Override
    public void delete(M mapper, T o) {
        mapper.delete(o);
    }

    @Override
    public void deleteById(M mapper, PK id) {
        mapper.deleteById(id);
    }
}
