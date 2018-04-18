package com.plf.manage.dao;

import java.util.List;

import com.plf.manage.domain.Student;

public interface StudentDao {

	public Student findByUnAndPw(String username, String password);

	public boolean save(Student student);
	
	public List<Student> getStudentList(Integer teacherId);

}
