package com.wq.springboot.common.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDao {
    Serializable save(Object entity);
    void update(Object entity);
    void saveOrUpdate(Object entity);
    void persist(Object entity);

    void delete(Object entity);
    void deleteById(Class<?> clazz, Serializable id);

    void flush();

    Object loadById(Class<?> clazz, Serializable id);

    Object getById(Class<?> clazz, Serializable id);
    Object getReferenceById(Class<?> clazz, Serializable id);
    Object getBySimpleNaturalId(Class<?> clazz, Object idValue);
    Object getByNaturalId(Class<?> clazz, Map<String, Object> idValues);

    int getCount(Class<?> clazz);

    @SuppressWarnings("rawtypes")
    List getAll(Class<?> clazz);
    @SuppressWarnings("rawtypes")
    List getAll(Class<?> clazz, String orderBy);

    @SuppressWarnings("rawtypes")
    List getByRange(Class<?> clazz, int firstRowNo, int maxResult);
    @SuppressWarnings("rawtypes")
    List getByRange(Class<?> clazz, int firstRowNo, int maxResult, String orderBy);

    @SuppressWarnings("rawtypes")
    List query(String hql);
    @SuppressWarnings("rawtypes")
    List query(String hql, int firstRowNo, int maxResult);
    @SuppressWarnings("rawtypes")
    List query(String hql, Map<String, Object> parameters);
    @SuppressWarnings("rawtypes")
    List query(String hql, Map<String, Object> parameters, int firstRowNo, int maxResult);

    int executeUpdate(String hql);
    int executeUpdate(String hql, Map<String, Object> parameters);

    Object queryUniqueResult(String hql);
    Object queryUniqueResult(String hql, Map<String, Object> parameters);

    Object sqlQueryUniqueueResult(String sql);
    List<Map<String, Object>> sqlQuery(String sql);
    Object sqlQueryUniqueueResult(String sql, Map<String, Object> parameters);
    List<Map<String, Object>> sqlQuery(String sql, Map<String, Object> parameters);

    int sqlExecuteUpdate(String sql);
    int sqlExecuteUpdate(String sql, Map<String, Object> parameters);
}
