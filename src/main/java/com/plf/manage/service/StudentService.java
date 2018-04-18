package com.plf.manage.service;

import java.util.List;

import com.plf.manage.domain.Student;

/**
 * 学生业务类
 * @author plf 2017年11月19日下午7:00:54
 *
 */
public interface StudentService {
	public Student login(String username,String password);

	public boolean save(Student student);
	
	public List<Student> getStudentList(Integer teacherId);
}
