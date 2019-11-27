package com.wq.springboot.common.service.impl;

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

import com.wq.springboot.common.service.JpaBaseService;

public abstract class JpaBaseServiceImpl<T extends Serializable, PK extends Serializable>
		implements JpaBaseService<T, PK> {
	
	@SuppressWarnings("rawtypes")
	@Autowired
	private JpaRepository jpaRepository;

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	public JpaBaseServiceImpl() {
	}

	@SuppressWarnings("rawtypes")
	protected JpaRepository getJpaRepository() {
		return jpaRepository;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getById(PK id) {
		return (T) jpaRepository.getOne(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(Sort sortx) {
		if(sortx != null) {
			return jpaRepository.findAll(sortx);
		} else {
			return jpaRepository.findAll();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<T> getByPage(int pageNo, int pageSize, Sort sortx) {
		return jpaRepository.findAll(PageRequest.of(pageNo, pageSize, sortx));
	}
	
	@Override
	public long count() {
		return jpaRepository.count();
	}
		
	@SuppressWarnings("unchecked")
	@Override
	public void save(T o) {
		jpaRepository.save(o);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void saveAndFlush(T o) {
		jpaRepository.saveAndFlush(o);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(T o) {
		jpaRepository.delete(o);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteById(PK id) {
		jpaRepository.deleteById(id);
	}
	
	@Override
	public void flush() {
		jpaRepository.flush();
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
