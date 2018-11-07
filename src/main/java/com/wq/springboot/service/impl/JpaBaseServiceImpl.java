package com.wq.springboot.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.wq.springboot.service.JpaBaseService;

public abstract class JpaBaseServiceImpl<T extends Serializable, PK extends Serializable>
		implements JpaBaseService<T, PK> {
	
	@SuppressWarnings("rawtypes")
	@Autowired
	private JpaRepository baseDao;

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	public JpaBaseServiceImpl() {
	}

	@SuppressWarnings("rawtypes")
	protected JpaRepository getDao() {
		return baseDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getById(PK id) {
		return (T) baseDao.getOne(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(Sort sortx) {
		if(sortx != null) {
			return baseDao.findAll(sortx);
		} else {
			return baseDao.findAll();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<T> getByPage(int pageNo, int pageSize, Sort sortx) {
		return baseDao.findAll(PageRequest.of(pageNo, pageSize, sortx));
	}
	
	@Override
	public long count() {
		return baseDao.count();
	}
		
	@SuppressWarnings("unchecked")
	@Override
	public void save(T o) {
		baseDao.save(o);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(T o) {
		baseDao.delete(o);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteById(PK id) {
		baseDao.deleteById(id);
	}

	@Override
	public int executeSql(String sql) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createNativeQuery(sql);
		int ret = query.executeUpdate();
        em.getTransaction().commit();
		em.close();
		return ret;
	}

}
