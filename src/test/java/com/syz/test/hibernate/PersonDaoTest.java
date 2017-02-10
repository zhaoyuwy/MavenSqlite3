package com.syz.test.hibernate;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.syz.test.dao.PersonDao;
import com.syz.test.entity.Person;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })

public class PersonDaoTest extends Thread {

	@Resource(name = "PersonDaoImpl")
	public PersonDao personDao;


	// @Ignore
	@Test
	public void testWritePerson() throws InterruptedException {
		

		for (int i = 0; i < 2; i++) {
			Person person = new Person();
			person.setAge(2);
			person.setName(String.valueOf(i) +"a");
			personDao.save(person);
			Thread.sleep(1000);
		}
	}

	@Test
	public void testWritePerson2() throws InterruptedException {
		for (int i = 0; i < 2; i++) {
			Person person = new Person();
			person.setAge(3);
			person.setName(String.valueOf(i) +"b");
//			personDao.save(person);
			Thread.sleep(1000);
		}
	}
	
	private String name;
//    public PersonDaoTest(String name) {
//       this.name=name;
//    }
	public void run() {
        for (int i = 0; i < 2; i++) {
            System.out.println(name + "ÔËÐÐ  :  " + i);
            try {
        		ApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
    			PersonDao personDao = (PersonDao) ac.getBean("PersonDaoImpl");
    			Person person = new Person();
    			person.setAge(3);
    			person.setName(String.valueOf("ddddddddd    ")+"1111111111111");
    			personDao.save(person);
                sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
       
	}
	

		public static void main(String[] args) {
			
			
//			ApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
//			PersonDao personDao = (PersonDao) ac.getBean("PersonDaoImpl");
//			Person person = new Person();
//			person.setAge(3);
//			person.setName(String.valueOf("ddddddddd    ")+"b");
//			personDao.save(person);
			PersonDaoTest mTh1=new PersonDaoTest();
			PersonDaoTest mTh2=new PersonDaoTest();
			mTh1.start();
			mTh2.start();

		}
}