package com.plf.manage.util;

/**
 * 返回的规范类，struts除了返回跳转页面不需要，其他必须用到这个类
 * @author plf 2017年11月19日下午10:12:09
 *
 */
public class Result<T> {
	public static final int SUCCESS = 0;
	public static final int FAIL = 1;
	
	private T data;
	private int status = SUCCESS;
	private String message;
	
	public Result(){
		super();
	}
	
	//正常返回
	public Result(T data,int status,String message){
		this.data=data;
		this.status=status;
		this.message=message;
	}
	
	//只存入一个异常
	public Result(Throwable e){
		this.data=null;
		this.status=FAIL;
		this.message=e.getMessage();
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
