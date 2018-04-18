package com.plf.manage.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 老师类
 * @author plf 2018年4月12日上午9:41:43
 *
 */
@Entity
@Table(name="teacher")
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String username;//用户名
	@Column
	private String password;//密码
	@Column
	private String realname;//真名
	@ManyToOne
	@JoinColumn(name="classNameId")
	private ClassName className;//所教的课程名
	@Column
	private Integer teacherType;//0 普通老师  1班主任--1可看自己班的学生成绩  0 只能看自己的课的成绩
	@Column
	private Integer classType;//1-6代表6个年级
	@Column
	private Integer status; //0正常  1 异常(离职等情况)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ClassName getClassName() {
		return className;
	}
	public void setClassName(ClassName className) {
		this.className = className;
	}
	public Integer getTeacherType() {
		return teacherType;
	}
	public void setTeacherType(Integer teacherType) {
		this.teacherType = teacherType;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public Integer getClassType() {
		return classType;
	}
	public void setClassType(Integer classType) {
		this.classType = classType;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", username=" + username + ", password=" + password + ", realname=" + realname
				+ ", className=" + className + ", teacherType=" + teacherType + ", classType=" + classType + ", status="
				+ status + "]";
	}
}
