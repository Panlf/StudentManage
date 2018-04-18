package com.plf.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plf.manage.dao.ManageDao;
import com.plf.manage.domain.Manage;
import com.plf.manage.service.ManageService;

@Service
@Scope("prototype")
@Transactional
public class ManageServiceImpl implements ManageService {

	@Autowired
	private ManageDao manageDao;
	
	@Override
	public Manage login(String username, String password) {
		return manageDao.findByUnAndPw(username, password);
	}
}
