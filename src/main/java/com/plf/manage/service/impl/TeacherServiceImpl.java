package com.plf.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plf.manage.dao.TeacherDao;
import com.plf.manage.domain.Teacher;
import com.plf.manage.service.TeacherService;
import com.plf.manage.util.PageBean;

@Service
@Scope("prototype")
@Transactional
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherDao teacherDao;
	
	@Override
	public Teacher login(String username, String password) {
		return teacherDao.findByUnAndPw(username, password);
	}

	@Override
	public void save(Teacher teacher) {
		teacherDao.save(teacher);
	}

	@Override
	public void update(Teacher teacher) {
		teacherDao.update(teacher);

	}

	@Override
	public PageBean<Teacher> getPageList(Integer pageSize, Integer pageNumber, String realName) {
		PageBean<Teacher> page = new PageBean<Teacher>();
		page.setPre(false);
		page.setNext(false);
		page.setPage(pageNumber);
		page.setLimit(pageSize);
		Integer totalCount  =  teacherDao.countTeacher(realName);
		//总页面
		Integer totalPage=0;
		if(totalCount % pageSize == 0){
			totalPage=totalCount/pageSize;
		}else{
			totalPage=totalCount/pageSize+1;
		}
		if(pageNumber>1){
			page.setPre(true);
		}
		if(pageNumber<totalPage){
			page.setNext(true);
		}
		page.setTotalCount(totalCount);
		page.setTotalPage(totalPage);
		int begin =(pageNumber-1)*pageSize;
		List<Teacher> list=teacherDao.getPageList(begin, pageSize, realName);
		page.setList(list);
		return page;
	}

	@Override
	public Teacher getId(Integer id) {
		return teacherDao.getId(id);
	}

}
