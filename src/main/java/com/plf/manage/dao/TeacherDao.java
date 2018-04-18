package com.plf.manage.dao;

import java.util.List;

import com.plf.manage.domain.Teacher;

public interface TeacherDao {

	public Teacher findByUnAndPw(String username, String password);

	public void save(Teacher teacher);
	
	public void update(Teacher teacher);
	
	public Integer countTeacher(String realname);
	
	public List<Teacher> getPageList(Integer begin,Integer limit,String realname);

	public Teacher getId(Integer id);
}
