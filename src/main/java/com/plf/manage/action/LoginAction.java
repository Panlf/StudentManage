package com.plf.manage.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.plf.manage.domain.Student;
import com.plf.manage.service.StudentService;

/**
 * 学生登录Action
 * @author plf 2017年11月17日下午9:19:22
 *
 */

@Scope("prototype")
@Controller
public class LoginAction extends ActionSupport implements ModelDriven<Student> {

	private static final long serialVersionUID = 1919934404750494992L;
	
	
	private Student student=new Student();
	
	public void setStudent(Student student) {
		this.student = student;
	}

	public Student getModel() {
		// TODO Auto-generated method stub
		return student;
	}
	@Autowired
	private StudentService studentService;
	
	private Map<String,Object> data=new HashMap<String,Object>(1);
	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	public String login(){
		if(studentService.login(student.getUsername(), student.getPassword())){
			ActionContext.getContext().getSession().put("existUser", student.getUsername());
			return SUCCESS;
		}
		return INPUT;
	}
	
	public String goIndex(){
		return "index";
	}

}
