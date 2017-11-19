package com.plf.manage.action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.plf.manage.domain.Student;

/**
 * 学生登录Action
 * @author plf 2017年11月17日下午9:19:22
 *
 */
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
	
	private Map<String,Object> data=new HashMap<String,Object>(1);
	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	public String login(){
		if(student.getUsername().equals("pcq") && student.getPassword().equals("0927")){
			ActionContext.getContext().getSession().put("existUser", "pcq");
			return SUCCESS;
		}
		return INPUT;
	}
	
	public String goIndex(){
		return "index";
	}

}
