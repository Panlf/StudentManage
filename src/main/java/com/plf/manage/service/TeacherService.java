package com.plf.manage.service;

import com.plf.manage.domain.Teacher;
import com.plf.manage.util.PageBean;

/**
 * 
 * @author plf 2018年4月16日下午3:50:08
 *
 */
public interface TeacherService {
	public Teacher login(String username,String password);

	public void save(Teacher teacher);
	
	public void update(Teacher teacher);
	
	public PageBean<Teacher> getPageList(Integer pageSize,Integer pageNumber,String realName);
	
	public Teacher getId(Integer id);
}
