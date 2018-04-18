package com.plf.manage.dao;

import java.util.List;

import com.plf.manage.domain.Grade;
import com.plf.manage.dto.GradeDto;
import com.plf.manage.dto.MyScoreDto;

public interface GradeDao {
	
	public void save(Grade grade);
	
	public void update(Grade grade);
	
	public List<GradeDto> list(Integer teacherId);
	
	public List<MyScoreDto> listMyScore(Integer studentId);
}
