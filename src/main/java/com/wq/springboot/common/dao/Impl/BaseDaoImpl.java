package com.wq.springboot.common.dao.Impl;

import com.wq.springboot.common.dao.BaseDao;
import org.hibernate.NaturalIdLoadAccess;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.query.NativeQuery;
//import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;

@Repository
public class BaseDaoImpl implements BaseDao {
    // @Autowired
    // private SessionFactory sessionFactory;

    // private Session getCurrentSession(){
    //     return this.sessionFactory.getCurrentSession();
	// }
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;

    private Session getCurrentSession(){
        return this.entityManagerFactory.unwrap(SessionFactory.class).getCurrentSession();
	}

	@Override
    public Serializable save(Object entity) {
        return this.getCurrentSession().save(entity);
    }

    @Override
    public void update(Object entity) {
        this.getCurrentSession().update(entity);
    }

    @Override
    public void saveOrUpdate(Object entity) {
        this.getCurrentSession().saveOrUpdate(entity);

    }

    @Override
    public void persist(Object entity) {
        this.getCurrentSession().persist(entity);

    }

    @Override
    public void delete(Object entity) {
        this.getCurrentSession().delete(entity);
    }

    @Override
    public void deleteById(Class<?> clazz, Serializable id) {
        Object entity = this.getReferenceById(clazz, id);
        if(entity != null)
            this.delete(entity);
    }

    @Override
    public void flush() {
        this.getCurrentSession().flush();
    }

    @Override
    public Object loadById(Class<?> clazz, Serializable id) {
        return this.getCurrentSession().load(clazz, id);
    }

    @Override
    public Object getById(Class<?> clazz, Serializable id) {
        return this.getCurrentSession().get(clazz, id);
    }

    @Override
    public Object getReferenceById(Class<?> clazz, Serializable id) {
        return this.getCurrentSession().byId(clazz).getReference(id);
    }

    @Override
    public Object getBySimpleNaturalId(Class<?> clazz, Object idValue) {
        return this.getCurrentSession().bySimpleNaturalId(clazz).load(idValue);
    }

	@SuppressWarnings("rawtypes")
    @Override
    public Object getByNaturalId(Class<?> clazz, Map<String, Object> idValues) {
        NaturalIdLoadAccess loader = this.getCurrentSession().byNaturalId(clazz);
        for(String key : idValues.keySet()) {
            loader.using(key, idValues.get(key));
        }
        return loader.load();
    }

    @Override
    public int getCount(Class<?> clazz) {
        String hql = String.format("select count(a) from %s as a", clazz.getSimpleName());
        return ((Number)this.queryUniqueResult(hql)).intValue();
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List getAll(Class<?> clazz) {
        String hql = String.format("from %s", clazz.getSimpleName());
        return this.query(hql);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List getAll(Class<?> clazz, String orderBy) {
        String hql = String.format("from %s order by %s", clazz.getSimpleName(), orderBy);
        return this.query(hql);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List getByRange(Class<?> clazz, int firstRowNo, int maxResult) {
        String hql = String.format("from %s", clazz.getSimpleName());
        return this.query(hql, firstRowNo, maxResult);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List getByRange(Class<?> clazz, int firstRowNo, int maxResult,
                           String orderBy) {
        String hql = String.format("from %s order by %s", clazz.getSimpleName(), orderBy);
        return this.query(hql, firstRowNo, maxResult);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List query(String hql) {
        return this.query(hql, null);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List query(String hql, int firstRowNo, int maxResult) {
        return this.query(hql, null, firstRowNo, maxResult);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List query(String hql, Map<String, Object> parameters) {
        Query query = this.getCurrentSession().createQuery(hql);
        if(parameters != null) {
            for(String s : parameters.keySet()) {
                query.setParameter(s, parameters.get(s));
            }
        }
        return query.list();
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List query(String hql, Map<String, Object> parameters, int firstRowNo,
                      int maxResult) {
        Query query = this.getCurrentSession().createQuery(hql);
        query.setFirstResult(firstRowNo).setMaxResults(maxResult);
        if(parameters != null) {
            for(String s : parameters.keySet()) {
                query.setParameter(s, parameters.get(s));
            }
        }
        return query.list();
    }

    @Override
    public Object queryUniqueResult(String hql) {
        return this.queryUniqueResult(hql, null);
    }

	@SuppressWarnings("rawtypes")
    @Override
    public Object queryUniqueResult(String hql, Map<String, Object> parameters) {
        Query query = this.getCurrentSession().createQuery(hql);
        if(parameters != null) {
            for(String s : parameters.keySet()) {
                query.setParameter(s, parameters.get(s));
            }
        }
        return query.uniqueResult();
    }

    @Override
    public int executeUpdate(String hql) {
        return this.executeUpdate(hql, null);
    }

	@SuppressWarnings("rawtypes")
    @Override
    public int executeUpdate(String hql, Map<String, Object> parameters) {
        Query query = this.getCurrentSession().createQuery(hql);
        if(parameters != null) {
            for(String s : parameters.keySet()) {
                query.setParameter(s, parameters.get(s));
            }
        }
        return query.executeUpdate();
    }

    @Override
    public Object sqlQueryUniqueueResult(String sql) {
        return this.sqlQueryUniqueueResult(sql, null);
    }

    @Override
    public List<Map<String, Object>> sqlQuery(String sql) {
        return this.sqlQuery(sql, null);
    }

	@SuppressWarnings("rawtypes")
    @Override
    public Object sqlQueryUniqueueResult(String sql, Map<String, Object> parameters) {
        NativeQuery query = this.getCurrentSession().createNativeQuery(sql);
        if(parameters != null) {
            for(String s : parameters.keySet()) {
                query.setParameter(s, parameters.get(s));
            }
        }
        return query.uniqueResult();
    }

	@SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public List<Map<String, Object>> sqlQuery(String sql, Map<String, Object> parameters) {
		NativeQuery query = this.getCurrentSession().createNativeQuery(sql);
		//query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        if(parameters != null) {
            for(String s : parameters.keySet()) {
                query.setParameter(s, parameters.get(s));
            }
        }
        return query.getResultList();
    }

    @Override
    public int sqlExecuteUpdate(String sql) {
        return this.sqlExecuteUpdate(sql, null);
    }

	@SuppressWarnings("rawtypes")
    @Override
    public int sqlExecuteUpdate(String sql, Map<String, Object> parameters) {
        NativeQuery query = this.getCurrentSession().createNativeQuery(sql);
        if(parameters != null) {
            for(String s : parameters.keySet()) {
                query.setParameter(s, parameters.get(s));
            }
        }
        return query.executeUpdate();
    }
}
