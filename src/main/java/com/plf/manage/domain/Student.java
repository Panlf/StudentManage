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
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;//主键ID
	
	
	private String number;//学号
	
	
	private String realname;//真名
	
	
	private String username;//网站用户名
	

	private String password;//密码
	

	private int sex;//0 男生 1女生 2不详
	
	
	private Date birthday;//生日
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Column(name="number",nullable=false)
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Column(name="sex",nullable=false)
	public int getSex() {
		return sex;
	}
	
	public void setSex(int sex) {
		this.sex = sex;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="birthday",nullable=false)
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Id
	@Column(name="id",unique = true)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="realname",nullable=false)
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	@Column(name="username",nullable=false)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name="password",nullable=false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
