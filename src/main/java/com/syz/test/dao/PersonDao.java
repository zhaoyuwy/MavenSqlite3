package com.syz.test.dao;

import java.util.List;

import com.syz.test.entity.Person;

public interface PersonDao {

	public void save(Person p);

	public void delete(Person p);

	public void update(Person p);
	public void clear();

	public Person findById(String id);

	public List<Person> list();

}