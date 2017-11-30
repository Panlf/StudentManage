package com.plf.manage.dao;

import com.plf.manage.domain.Student;

public interface StudentDao {

	Student findByUnAndPw(String username, String password);

	boolean save(Student student);

}
