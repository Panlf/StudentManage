package com.plf.manage.service;

import java.util.List;

import com.plf.manage.domain.ClassName;
import com.plf.manage.util.PageBean;

public interface ClassNameService {
	public PageBean<ClassName> getClassNameList(Integer pageSize,Integer pageNumber);

	public void save(ClassName className);
	
	public void update(ClassName className);

	public ClassName getId(Integer id);
	
	public List<ClassName> getClassName();
}
