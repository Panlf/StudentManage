package com.plf.manage.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.plf.manage.dao.ManageDao;
import com.plf.manage.domain.Manage;

@Repository
@Scope("prototype")
public class ManageDaoImpl implements ManageDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public Manage findByUnAndPw(String username, String password) {
		Manage result= (Manage)sessionFactory.getCurrentSession().createQuery("from Manage where username=:username and password=:password")
		.setParameter("username", username).setParameter("password", password).uniqueResult();	
		return result;
	}

}
