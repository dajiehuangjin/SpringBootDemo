package com.wq.springboot.common.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

//Jpa BaseService
public interface JpaBaseService<T extends Serializable, PK extends Serializable> {

	T getById(PK id);
	List<T> getAll(Sort sortx);
	Page<T> getByPage(int pageNo, int pageSize, Sort sortx);
	
	long count();
	
	void save(T o);

	void saveAndFlush(T o);
	
	void delete(T o);

	void deleteById(PK id);

	void flush();

	int executeSql(String sql);
}
