package com.wq.springboot.mapper;

import java.io.Serializable;
import java.util.List;

// 测试用的
public interface GenericMapper<T,PK extends Serializable> {
    T getById(PK id);
    List<T> findAll();
    List<T> getAllByOrder(String orderBy);
    List<T> getByRange(int firstRowNo, int maxResult);
    List<T> getByRangeByOrder(int firstRowNo, int maxResult, String orderBy);

    void persist(T entity);
    PK save(T entity);
    void saveOrUpdate(T entity);
    void delete(T entity);
    void deleteById(PK id);
    int getCount();
    void flush();

    int sqlExecute(String sql);
}
