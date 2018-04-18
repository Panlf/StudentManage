package com.plf.manage.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.plf.manage.domain.Manage;
import com.plf.manage.service.ManageService;

public class ManageAction extends ActionSupport implements ModelDriven<Manage>{

	private static final long serialVersionUID = -2615931089497767499L;
	
	Manage manage = new Manage();
	
	public void setManage(Manage manage) {
		this.manage = manage;
	}

	@Override
	public Manage getModel() {
		return manage;
	}
	@Autowired
	private ManageService manageService;
	private Map<String,Object> data=new HashMap<String,Object>(1);
	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public String login(){
		Manage m=manageService.login(manage.getUsername(), manage.getPassword());
		if(m!=null){
			ActionContext.getContext().getSession().put("existUser", m.getRolename());
			data.put("code",1);
		}else{
			data.put("code",0);
		}
		return SUCCESS;
	}
	
	public String loginout(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
}
