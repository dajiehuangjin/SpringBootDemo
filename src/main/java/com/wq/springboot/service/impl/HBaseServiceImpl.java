package com.wq.springboot.service.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wq.springboot.common.dao.BaseDao;
import com.wq.springboot.service.HBaseService;

public abstract class HBaseServiceImpl<T extends Serializable, PK extends Serializable>
		implements HBaseService<T, PK> {
	
	@Autowired
	private BaseDao baseDao;
	
	private Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public HBaseServiceImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		entityClass = (Class<T>) type.getActualTypeArguments()[0];
	}
	
	protected BaseDao getDao() {
		return baseDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(PK id) {
		return (T) baseDao.getById(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> get(String field, String order) {
		if(field != null && order != null) {
			return baseDao.getAll(entityClass, field + " " + order);
		} else {
			return baseDao.getAll(entityClass);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> get(int pageNo, int pageSize, String field, String order) {
		if(field != null && order != null) {
			return baseDao.getByRange(entityClass, (pageNo - 1) * pageSize, pageSize, field + " " + order);
		} else {
			return baseDao.getByRange(entityClass, (pageNo - 1) * pageSize, pageSize);
		}
	}
	
	@Override
	public int count() {
		return baseDao.getCount(entityClass);
	}
		
	@Override
	public void save(T o) {
		baseDao.save(o);
	}

	@Override
	public void update(T o) {
		baseDao.update(o);
	}

	@Override
	public void delete(T o) {
		baseDao.delete(o);
	}

	@Override
	public void deleteById(PK id) {
		baseDao.deleteById(entityClass, id);
	}

}
