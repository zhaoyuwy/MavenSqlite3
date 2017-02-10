package com.syz.test.dao.impl;

import org.springframework.stereotype.Service;

import com.syz.test.dao.DogDao;
import com.syz.test.entity.Dog;


//@Repository(value = "DogDao")  
@Service("dogDao")
public class DogDaoImpl  extends BaseDaoImpl<Dog> implements DogDao{

}
