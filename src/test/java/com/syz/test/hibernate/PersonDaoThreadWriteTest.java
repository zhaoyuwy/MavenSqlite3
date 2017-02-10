package com.syz.test.hibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.syz.test.dao.PersonDao;
import com.syz.test.entity.Person;

public class PersonDaoThreadWriteTest extends Thread {
	private static Logger logger = LoggerFactory.getLogger(PersonDaoThreadWriteTest.class);
	private String name;

	public PersonDaoThreadWriteTest(String name) {
		this.name = name;
	}

	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(name + "运行  :  " + i);
			try {
				ApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
				PersonDao personDao = (PersonDao) ac.getBean("PersonDaoImpl");
				Person person = new Person();
				person.setAge(i);
				logger.error("insert  "+ name + i);
				person.setName(String.valueOf("name") + name + "  " + String.valueOf(i));
				personDao.save(person);
				if ("我是1".endsWith(name)) {
					sleep((int) Math.random() * 1);
				}
				System.out.println();
			} catch (InterruptedException e) {
				logger.error(" save error ", e);
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {

		// ApplicationContext ac = new
		// ClassPathXmlApplicationContext("/applicationContext.xml");
		// PersonDao personDao = (PersonDao) ac.getBean("PersonDaoImpl");
		// Person person = new Person();
		// person.setAge(3);
		// person.setName(String.valueOf("ddddddddd ")+"b");
		// personDao.save(person);
		PersonDaoThreadWriteTest mTh1 = new PersonDaoThreadWriteTest("我是1");
		PersonDaoThreadWriteTest mTh2 = new PersonDaoThreadWriteTest("wosi2");
		mTh1.start();
		mTh2.start();

	}
}