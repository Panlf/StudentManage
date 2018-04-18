package com.plf.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plf.manage.dao.ClassNameDao;
import com.plf.manage.domain.ClassName;
import com.plf.manage.service.ClassNameService;
import com.plf.manage.util.PageBean;

@Service
@Scope("prototype")
@Transactional
public class ClassNameServiceImpl implements ClassNameService{

	@Autowired
	private ClassNameDao classNameDao;
	
	@Override
	public PageBean<ClassName> getClassNameList(Integer pageSize, Integer pageNumber) {
		PageBean<ClassName> page = new PageBean<ClassName>();
		page.setPre(false);
		page.setNext(false);
		page.setPage(pageNumber);
		page.setLimit(pageSize);
		Integer totalCount  =  classNameDao.countClassName();
		//总页面
		Integer totalPage=0;
		if(totalCount % pageSize == 0){
			totalPage=totalCount/pageSize;
		}else{
			totalPage=totalCount/pageSize+1;
		}
		if(pageNumber>1){
			page.setPre(true);
		}
		if(pageNumber<totalPage){
			page.setNext(true);
		}
		page.setTotalCount(totalCount);
		page.setTotalPage(totalPage);
		int begin =(pageNumber-1)*pageSize;
		List<ClassName> list=classNameDao.getClassNameList(begin, pageSize);
		page.setList(list);
		return page;
	}

	@Override
	public void save(ClassName className) {
		classNameDao.saveClassName(className);
	}

	@Override
	public void update(ClassName className) {
		classNameDao.updateClassName(className);
	}

	@Override
	public ClassName getId(Integer id) {
		return classNameDao.getId(id);
	}

	@Override
	public List<ClassName> getClassName() {
		return classNameDao.getClassName();
	}
	
}
