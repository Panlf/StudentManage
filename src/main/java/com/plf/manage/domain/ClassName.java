package com.plf.manage.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

/**
 * 学科类
 * @author plf 2018年4月12日上午9:42:00
 *
 */
@Entity
@Table(name="classname")
@DynamicUpdate(true)
public class ClassName {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String className;
	@Column
	private Integer status; // 0 是有效  1 代表无效
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "ClassName [id=" + id + ", className=" + className + ", status=" + status + "]";
	}
	
	
}
