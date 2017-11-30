package com.plf.manage.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 学生类
 * @author plf 2017年11月17日下午9:16:30
 *
 */
@Entity
@Table(name="student")
public class Student {
	@Id
	@Column(name="id",unique = true,nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;//主键ID
	
	@Column(name="number",nullable=false)
	private String number;//学号
	
	@Column(name="realname",nullable=false)
	private String realname;//真名
	
	@Column(name="username",nullable=false)
	private String username;//网站用户名
	
	@Column(name="password",nullable=false)
	private String password;//密码
	
	@Column(name="sex",nullable=false)
	private int sex;//0 男生 1女生 2不详
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="birthday",nullable=false)
	private Date birthday;//生日
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public int getSex() {
		return sex;
	}
	
	public void setSex(int sex) {
		this.sex = sex;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
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
}
