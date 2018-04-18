package com.plf.manage.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.plf.manage.dao.ClassNameDao;
import com.plf.manage.domain.ClassName;

@Repository
@Scope("prototype")
@SuppressWarnings("unchecked")
public class ClassNameDaoImpl implements ClassNameDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<ClassName> getClassNameList(Integer begin,Integer limit) {
		List<ClassName> list=sessionFactory.getCurrentSession().createQuery("from ClassName")
		.setFirstResult(begin)
		.setFetchSize(limit).list();
		return list;
	}

	@Override
	public void saveClassName(ClassName className) {
		sessionFactory.getCurrentSession().save(className);
	}

	@Override
	public void updateClassName(ClassName className) {
		sessionFactory.getCurrentSession().update(className);
	}

	@Override
	public Integer countClassName() {
		Long count = (Long) sessionFactory.getCurrentSession().createQuery("select count(*) from ClassName").uniqueResult();
		return count.intValue();
	}

	@Override
	public ClassName getId(Integer id) {
		return (ClassName) sessionFactory.getCurrentSession().createQuery("from ClassName where id=:id").setParameter("id", id).uniqueResult();
	}

	@Override
	public List<ClassName> getClassName() {
		return (List<ClassName>) sessionFactory.getCurrentSession().createQuery("from ClassName where status=0").list();
	}

}
