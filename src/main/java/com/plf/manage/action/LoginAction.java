package com.plf.manage.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
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
		return student;
	}
	private Integer teacherId;
	
	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
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
	
	//登录操作
	public String login(){
		Student s =studentService.login(student.getUsername(), student.getPassword());
		if(s!=null){
			ActionContext.getContext().getSession().put("existUser", s.getRealname());
			ServletActionContext.getRequest().getSession().setAttribute("existUserType", "0");
			ServletActionContext.getRequest().getSession().setAttribute("existUserId", s.getId());
			data.put("code",1);
		}else{
			data.put("code",0);
		}
		return SUCCESS;
	}
	
	//注册操作
	public String save(){
		if(studentService.save(student)){
			data.put("code",1);
			return SUCCESS;
		}else{
			data.put("code",0);
			return SUCCESS;
		}
	}
	
	public String loginout(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
	
	public String list(){
		data.put("result",studentService.getStudentList(teacherId));
		return SUCCESS;
	}

}
