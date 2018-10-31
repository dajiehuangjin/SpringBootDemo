package com.wq.springboot.common.mapper;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

//基础Mapper
public interface BaseMapper {
    //save: 在hibernate事务里执行到save，会向数据库插一条数据，如果事务里异常，会回滚，删除数据库中插入的数据。
    // Serializable save(@Param("entity") Object entity);
    //persist: 在hibernate事务里执行到persist，不会向数据库插数据，事务commit了才会插入数据。
    // void persist(@Param("entity") Object entity);
    // flush: 主要作用就是清理缓存,强制数据库与Hibernate缓存同步,以保证数据的一致性
    // void flush();

    void insert(@Param("entity") Object entity);
    void update(@Param("entity") Object entity);
    void delete(@Param("entity") Object entity);
    void deleteById(@Param("id") Serializable id);

    Object getById(@Param("id") Serializable id);

    int getCount();

    @SuppressWarnings("rawtypes")
    List getAll();
    @SuppressWarnings("rawtypes")
    List getAllByOrder(@Param("orderBy") String orderBy);

    @SuppressWarnings("rawtypes")
    List getByRange(@Param("firstRowNo") int firstRowNo, @Param("maxResult") int maxResult);
    @SuppressWarnings("rawtypes")
    List getByRangeByOrder(@Param("firstRowNo") int firstRowNo, @Param("maxResult") int maxResult, @Param("orderBy") String orderBy);

    Object sqlQueryUniqueueResult(@Param("sqlStr") String sqlStr);
    List<Map<String, Object>> sqlQuery(@Param("sqlStr") String sqlStr);

    int sqlExecute(@Param("sqlStr") String sqlStr);

}
