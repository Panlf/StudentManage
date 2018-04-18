package com.plf.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plf.manage.dao.GradeDao;
import com.plf.manage.domain.Grade;
import com.plf.manage.dto.GradeDto;
import com.plf.manage.dto.MyScoreDto;
import com.plf.manage.service.GradeService;

@Service
@Scope("prototype")
@Transactional
public class GradeServiceImpl implements GradeService {

	@Autowired
	private GradeDao gradeDao;
	
	@Override
	public void save(Grade grade) {
		gradeDao.save(grade);
	}

	@Override
	public void update(Grade grade) {
		gradeDao.update(grade);
	}

	@Override
	public List<GradeDto> list(Integer teacherId) {
		return gradeDao.list(teacherId);
	}

	@Override
	public List<MyScoreDto> listMyScore(Integer studentId) {
		return gradeDao.listMyScore(studentId);
	}
	

}
