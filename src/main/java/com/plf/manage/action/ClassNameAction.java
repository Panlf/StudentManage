package com.plf.manage.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.plf.manage.domain.ClassName;
import com.plf.manage.service.ClassNameService;
import com.plf.manage.util.PageBean;

/**
 * 课程类
 * @author plf 2018年4月16日上午10:20:41
 *
 */
@Scope("prototype")
@Controller
public class ClassNameAction extends ActionSupport implements ModelDriven<ClassName> {

	
	private static final long serialVersionUID = -7521218509089436926L;

	private ClassName className=new ClassName();

	public void setClassName(ClassName className) {
		this.className = className;
	}

	public ClassName getModel() {
		return className;
	}
	private Integer pageSize;
	
	private Integer pageNumber;
	
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
	@Autowired
	private ClassNameService classNameService;
	
	private Map<String,Object> data=new HashMap<String,Object>(1);
	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	public String pagelist(){
		PageBean<ClassName> page=classNameService.getClassNameList(pageSize,pageNumber);
		data.put("result", page);
		return SUCCESS;
	}
	
	public String save(){
		classNameService.save(className);
		return SUCCESS;
	}
	
	public String update(){
		classNameService.update(className);
		return SUCCESS;
	}
	
	public String getId(){
		data.put("result",classNameService.getId(className.getId()));
		return SUCCESS;
	}

	public String allNames(){
		data.put("result",classNameService.getClassName());
		return SUCCESS;
	}
}
