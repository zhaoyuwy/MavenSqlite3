package com.syz.test.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;

import org.hibernate.Query;

import org.hibernate.Session;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.orm.hibernate3.HibernateCallback;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.syz.test.dao.PersonDao;

import com.syz.test.entity.Person;

@Service("PersonDaoImpl")

@Transactional

public class PersonDaoImpl extends HibernateDaoSupport implements PersonDao {

	// 要使用之前，得注入sessionfactory

	@Autowired

	public void setSessionFactory0(SessionFactory sessionFactory) {

		super.setSessionFactory(sessionFactory);

	}

	@Transactional

	public void save(Person p) {

		getHibernateTemplate().saveOrUpdate(p);

	}

	@Transactional

	public void delete(Person p) {

		getHibernateTemplate().delete(p);

	}

	
	@Transactional

	public void update(Person p) {

		getHibernateTemplate().saveOrUpdate(p);

	}

	@Transactional(readOnly = true)

	public Person findById(String id) {

		return getHibernateTemplate().load(Person.class, id);

	}

	@SuppressWarnings("unchecked")

	@Transactional(readOnly = true)

	public List<Person> list() {

		return (List<Person>) getHibernateTemplate().executeWithNativeSession(

				new HibernateCallback<Object>() {

					public Object doInHibernate(Session session)

							throws HibernateException {

						Query query = session.createQuery("from Person  as obj");

						return query.list();

					}

				});

	}
	@Transactional
	public void clear() {
		getHibernateTemplate().clear();
	}

}