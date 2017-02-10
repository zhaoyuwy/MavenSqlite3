package com.cg;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@SuppressWarnings("unchecked")

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	private Class<T> entityClass;
	@Autowired
	public BaseDaoImpl() {  
        Type genType = getClass().getGenericSuperclass();  
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();  
        entityClass = (Class<T>) params[0];  
    } 
//	public void setSessionFactory0(SessionFactory sessionFactory) {
//
//		super.setSessionFactory(sessionFactory);
//
//	}
//
//	@Transactional
//
//	public void save(Person p) {
//
//		getHibernateTemplate().saveOrUpdate(p);
//
//	}
//
//	@Transactional
//
//	public void delete(Person p) {
//
//		getHibernateTemplate().delete(p);
//
//	}
//
//	
//	@Transactional
//
//	public void update(Person p) {
//
//		getHibernateTemplate().saveOrUpdate(p);
//
//	}

//	@Transactional(readOnly = true)
//
//	public Person findById(String id) {
//
//		return getHibernateTemplate().load(Person.class, id);
//
//	}
//
//	@SuppressWarnings("unchecked")
//
//	@Transactional(readOnly = true)
//
//	public List<Person> list() {
//
//		return (List<Person>) getHibernateTemplate().executeWithNativeSession(
//
//				new HibernateCallback<Object>() {
//
//					public Object doInHibernate(Session session)
//
//							throws HibernateException {
//
//						Query query = session.createQuery("from Person  as obj");
//
//						return query.list();
//
//					}
//
//				});
//
//	}
	@Transactional
	public void clear() {
		getHibernateTemplate().clear();
	}
	@Transactional
	public void save(T entity) {
		System.out.println(entity.toString());
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

	public T findById(Serializable id) {
		return (T) getHibernateTemplate().load(entityClass, id);
	}

	public List<T> findByHQL(String hql, Object... params) {
		return null;
	}

//	private Class<T> clazz;
//
//	/**
//	 * 
//	 * 通过构造方法指定DAO的具体实现类
//	 * 
//	 */
//
//	public BaseDaoImpl() {
//
//		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
//
//		clazz = (Class<T>) type.getActualTypeArguments()[0];
//
//		System.out.println("DAO的真实实现类是：" + this.clazz.getName());
//
//	}
//
//	/**
//	 * 
//	 * 向DAO层注入SessionFactory
//	 * 
//	 */
//
//	@Resource
//
//	private SessionFactory sessionFactory;
//
//	/**
//	 * 
//	 * 获取当前工作的Session
//	 * 
//	 */
//
//	protected Session getSession() {
//
//		return this.sessionFactory.getCurrentSession();
//
//	}
//
//	public void save(T entity) {
//
//		this.getSession().save(entity);
//
//	}
//
//	public void update(T entity) {
//
//		this.getSession().update(entity);
//
//	}
//
//	public void delete(Serializable id) {
//
//		this.getSession().delete(this.findById(id));
//
//	}
//
//	public T findById(Serializable id) {
//
//		return (T) this.getSession().get(this.clazz, id);
//
//	}
//
//	public List<T> findByHQL(String hql, Object... params) {
//
//		Query query = this.getSession().createQuery(hql);
//
//		for (int i = 0; params != null && i < params.length; i++) {
//
//			query.setParameter(i, params);
//
//		}
//
//		return query.list();
//
//	}

}