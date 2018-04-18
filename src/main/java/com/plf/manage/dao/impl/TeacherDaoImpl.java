package com.plf.manage.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.plf.manage.dao.TeacherDao;
import com.plf.manage.domain.Teacher;

@Repository
@Scope("prototype")
public class TeacherDaoImpl implements TeacherDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Teacher findByUnAndPw(String username, String password) {
		Teacher result= (Teacher)sessionFactory.getCurrentSession().createQuery("from Teacher where username=:username and password=:password")
				.setParameter("username", username).setParameter("password", password).uniqueResult();	
		return result;
	}

	@Override
	public void save(Teacher teacher) {
		sessionFactory.getCurrentSession().save(teacher);
	}

	@Override
	public void update(Teacher teacher) {
		sessionFactory.getCurrentSession().update(teacher);
	}

	@Override
	public Integer countTeacher(String realname) {
		String hql="select count(*) from Teacher tc";
		if(realname!=null){
			hql += " where tc.realname like '%"+realname+"%'";
		}
		Long count = (Long) sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
		return count.intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> getPageList(Integer begin, Integer limit, String realname) {
		String hql="from Teacher tc";
		if(realname!=null){
			hql += " where tc.realname like '%"+realname+"%'";
		}
		List<Teacher> list = sessionFactory.getCurrentSession().createQuery(hql).setFirstResult(begin)
				.setFetchSize(limit).list();;
		return list;
	}

	@Override
	public Teacher getId(Integer id) {
		return (Teacher) sessionFactory.getCurrentSession().createQuery("from Teacher where id=:id").setParameter("id", id).uniqueResult();
	}

}
