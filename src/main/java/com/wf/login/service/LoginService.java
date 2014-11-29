package com.wf.login.service;

import com.wf.base.service.BaseService;
import com.wf.model.SysUser;

public interface LoginService extends BaseService{
	public void addUser(SysUser sysUser);
}
