package com.syz.test.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.syz.test.dao.BaseDao;
import com.syz.test.entity.Cat;
import com.syz.test.service.CatService;

@Service("catService")

@Transactional
public class CatSercivceImpl extends BaseServiceImpl<Cat> implements CatService {

	@Resource(name = "catDao")
	public void setDao(BaseDao<Cat> dao) {
		super.setDao(dao);
	}
}
