package com.syz.test.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.syz.test.dao.BaseDao;

/**
 * 
 * BaseDaoImpl 定义DAO的通用操作的实现
 * 
 * 
 * 
 * @author Monday
 * 
 */
@Scope("prototype")
@Transactional
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

//	private Class<T> entityClass;
//	@Autowired
//	public BaseDaoImpl() {  
//        Type genType = getClass().getGenericSuperclass();  
//        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();  
//        entityClass = (Class<T>) params[0];  
//    } 
	@Transactional
	public void clear() {
		getHibernateTemplate().clear();
	}
	@Transactional
	public void save(T entity) {
//		System.out.println(Thread.getAllStackTraces());
		getHibernateTemplate().saveOrUpdate(entity);		
	}
	@Transactional
	public void update(T entity) {
		getHibernateTemplate().saveOrUpdate(entity);
		
	}
	@Transactional
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
//		getHibernateTemplate().delete(entityClass, id);
//		getHibernateTemplate().load(entity, id);
	}
	@Transactional
	public T findById(Serializable id) {
//		return (T) getHibernateTemplate().load(entityClass, id);
		return null;
	}
	@Transactional
	public List<T> findByHQL(String hql, Object... params) {
		return null;
	}


}