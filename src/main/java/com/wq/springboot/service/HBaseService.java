package com.wq.springboot.service;

import java.io.Serializable;
import java.util.List;

//Hibernate BaseService
public interface HBaseService<T extends Serializable, PK extends Serializable> {

	T get(PK id);
	List<T> get(String field, String order);
	List<T> get(int pageNo, int pageSize, String field, String order);
	
	int count();
	
	void save(T o);

	void update(T o);
	
	void delete(T o);

	void deleteById(PK id);

	int executeSql(String sql);
}
