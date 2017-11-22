package com.plf.manage.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.plf.manage.dao.StudentDao;
import com.plf.manage.domain.Student;

@Repository
@Scope("prototype")
public class StudentDaoImpl implements StudentDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public Student findByUnAndPw(String username, String password) {
		// TODO Auto-generated method stub
		 Student result= (Student)sessionFactory.openSession().createQuery("from Student where username=:username and password=:password")
		.setParameter("username", username).setParameter("password", password).uniqueResult();	
		return result;
	}

}
