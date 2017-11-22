package com.plf.manage.interceptor;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class MyLoginInterceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6398458952217735171L;
	//private static Logger log=LoggerFactory.getLogger(MyLoginInterceptor.class);
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init() {
		// TODO Auto-generated method stub

	}

	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		//log.info("当前进入拦截器的Action:{1}",invocation.getAction());
		if(invocation.getInvocationContext().getSession().get("existUser")==null && invocation.getAction().toString().indexOf("LoginAction")==-1){
			//log.info("当前进入拦截器的Action-{1},已经被拦截...",invocation.getAction());
			return "input";
		}
		return invocation.invoke();
	}

}
