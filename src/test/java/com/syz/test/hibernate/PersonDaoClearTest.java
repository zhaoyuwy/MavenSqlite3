package com.syz.test.hibernate;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.syz.test.dao.PersonDao;
import com.syz.test.entity.Person;

@ContextConfiguration(locations = { "/applicationContext.xml" })

public class PersonDaoClearTest extends AbstractJUnit4SpringContextTests {
	private static Logger logger = LoggerFactory.getLogger(PersonDaoClearTest.class);
	@Resource(name = "PersonDaoImpl")

	/*
	 * @Autowired
	 * 
	 * @Qualifier("personDaoImpl") 这两行代码和上面一行效果一样
	 */
	public PersonDao personDao;

	@Test

	public void testListPerson() {

		 List<Person> ll = personDao.list();
		 // javaVersion = System.getProperty("java.version");
		 for (Person p : ll) {
		
		 System.out.println(p.getName());
		
		 System.out.println(p.getAge());
		 logger.error("delete  "+ p.getName());
		 personDao.delete(p);
		 }
//		personDao.clear();
	}

}