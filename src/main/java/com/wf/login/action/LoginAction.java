package com.wf.login.action;

import com.wf.base.form.Constants;
import com.wf.login.form.LoginForm;
import com.wf.login.service.LoginService;

public class LoginAction extends LoginForm {
	
	private LoginService loginService;
	
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}


	public String addUser() throws Exception  {
		
		loginService.addUser(sysUser);
		
		jsondataMap.put("success", true);
		return Constants.RESULT_JSON_DATA_MAP;
		
	}
	
}
