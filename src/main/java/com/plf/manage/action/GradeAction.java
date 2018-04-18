package com.plf.manage.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.plf.manage.domain.Grade;
import com.plf.manage.domain.Student;
import com.plf.manage.domain.Teacher;
import com.plf.manage.service.GradeService;

public class GradeAction extends ActionSupport implements ModelDriven<Grade>{

	private static final long serialVersionUID = -1382445612680608169L;

	Grade grade =new Grade();
	
	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	@Override
	public Grade getModel() {
		return grade;
	}
	@Autowired
	private GradeService gradeService;
	private Map<String,Object> data=new HashMap<String,Object>(1);
	public Map<String, Object> getData() {
		return data;
	}
	
	private Integer studentId;
	
	private Integer teacherId;
	
	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	public String list(){
		data.put("result",gradeService.list(teacherId));
		return SUCCESS;
	}
	
	public String save(){
		Student student =new Student();
		student.setId(studentId);
		grade.setStudent(student);
		Teacher teacher = new Teacher();
		teacher.setId(teacherId);
		grade.setTeacher(teacher);
		gradeService.save(grade);
		return SUCCESS;
	}
	
	public String update(){
		Student student =new Student();
		student.setId(studentId);
		grade.setStudent(student);
		Teacher teacher = new Teacher();
		teacher.setId(teacherId);
		grade.setTeacher(teacher);
		gradeService.update(grade);
		return SUCCESS;
	}

	public String myScore(){
		data.put("result",gradeService.listMyScore(studentId));
		return SUCCESS;
	}
}
