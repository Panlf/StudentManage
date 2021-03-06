package com.plf.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plf.manage.dao.StudentDao;
import com.plf.manage.domain.Student;
import com.plf.manage.service.StudentService;

/**
 * 学生接口事务实现类
 * @author plf 2017年11月19日下午10:23:22
 *
 */
@Service
@Scope("prototype")
@Transactional
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao studentDao;
	public Student login(String username, String password) {
		Student student = studentDao.findByUnAndPw(username,password);
		return student;
	}
	@Override
	public boolean save(Student student) {
		if(studentDao.save(student)){
			return true;
		}
		return false;
	}
	@Override
	public List<Student> getStudentList(Integer teacherId) {
		return studentDao.getStudentList(teacherId);
	}

}
