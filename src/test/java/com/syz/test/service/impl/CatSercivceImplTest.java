package com.syz.test.service.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.syz.test.dao.CatDao;
import com.syz.test.entity.Cat;
import com.syz.test.hibernate.PersonDaoThreadWriteTest;
import com.syz.test.service.CatService;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class CatSercivceImplTest {
	@Resource(name = "catService")
	public CatService catService;

	@Test
	public void test() {
		// fail("Not yet implemented");
		Cat cat = new Cat();
		cat.setPassword("Œ“ «√®");
		cat.setUsername("rrrrrr");
		// dog2.save(dog);
		catService.save(cat);
	}

	@Test
	public void test3() {
		test();
	}

	public static void main(String[] args) {

//		ApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
//		CatDao dogService2 = (CatDao) ac.getBean("catDao");
//		System.out.println(dogService2.toString());
//		Cat dog = new Cat();
//		dog.setPassword("dddddd");
//		dog.setUsername("rrrrrr");
//		dogService2.save(dog);
		
//		CatThread mTh1 = new CatThread("catname_1");
//		CatThread mTh2 = new CatThread("catname_2");
//		mTh1.start();
//		mTh2.start();
		
		while(true){
			ApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
			CatDao catdao = (CatDao) ac.getBean("catDao");
			byte[] ar = new byte[1024*1024*50];
		}
		
	}
}

class CatThread extends Thread {
	private static Logger logger = LoggerFactory.getLogger(CatThread.class);
	private String name;

	public CatThread(String name) {
		this.name = name;
	}

	public void run() {
		for (int i = 0; i < 2; i++) {
			try {
				ApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
				CatDao catdao = (CatDao) ac.getBean("catDao");
				Cat cat = new Cat();
				cat.setPassword(String.valueOf(i));
				cat.setUsername(name);
				logger.info("insert  " + name +" "+ i);
				catdao.save(cat);
//				Serializable id = new 
//				catdao.findById(id);
				if ("catname_1".endsWith(name)) {
					sleep((int) Math.random() * 10);
				}
			} catch (InterruptedException e) {
				logger.error(" save error ", e);
			}
		}

	}
}
