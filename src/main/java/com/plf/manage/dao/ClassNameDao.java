package com.plf.manage.dao;

import java.util.List;

import com.plf.manage.domain.ClassName;

public interface ClassNameDao {

	public List<ClassName> getClassNameList(Integer begin,Integer limit);
	
	public void saveClassName(ClassName className);
	
	public void updateClassName(ClassName className);
	
	public Integer countClassName();
	
	public ClassName getId(Integer id);
	
	public List<ClassName> getClassName();
}
