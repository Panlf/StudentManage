package com.plf.manage.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.plf.manage.domain.ClassName;
import com.plf.manage.domain.Teacher;
import com.plf.manage.service.TeacherService;
import com.plf.manage.util.PageBean;

public class TeacherAction extends ActionSupport implements ModelDriven<Teacher>{

	private static final long serialVersionUID = 162141637255229572L;
	Teacher teacher = new Teacher();
	
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	
	@Override
	public Teacher getModel() {
		return teacher;
	}
	
	@Autowired
	private TeacherService teacherService;
	private Map<String,Object> data=new HashMap<String,Object>(1);
	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	private Integer pageSize;
	
	private Integer pageNumber;
	
	private Integer  classNameId; 
	
	public Integer getClassNameId() {
		return classNameId;
	}


	public void setClassNameId(Integer classNameId) {
		this.classNameId = classNameId;
	}


	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	public String login(){
		Teacher t=teacherService.login(teacher.getUsername(), teacher.getPassword());
		if(t!=null){
			ServletActionContext.getRequest().getSession().setAttribute("existUser", t.getRealname());
			ServletActionContext.getRequest().getSession().setAttribute("existUserType", "1");
			ServletActionContext.getRequest().getSession().setAttribute("existUserId", t.getId());
			ServletActionContext.getRequest().getSession().setAttribute("teacherType", t.getTeacherType());
			data.put("code",1);
		}else{
			data.put("code",0);
		}		
		return SUCCESS;
	}
	
	public String save(){
		ClassName className = new ClassName();
		className.setId(classNameId);
		teacher.setClassName(className);
		teacherService.save(teacher);
		return SUCCESS;
	}
	
	public String update(){
		ClassName className = new ClassName();
		className.setId(classNameId);
		teacher.setClassName(className);
		teacherService.update(teacher);
		return SUCCESS;
	}

	public String getId(){
		data.put("result", teacherService.getId(teacher.getId()));
		return SUCCESS;
	}
	
	public String pageList(){
		PageBean<Teacher> page=teacherService.getPageList(pageSize, pageNumber, teacher.getRealname());
		data.put("result", page);
		return SUCCESS;
	}
	
	public String loginout(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
}
