package com.wf.login.service;

import com.wf.base.service.BaseServiceImpl;
import com.wf.exception.DaoException;
import com.wf.model.SysUser;

public class LoginServiceImpl extends BaseServiceImpl implements LoginService {

	@Override
	public void addUser(SysUser sysUser) {
		try {
			saveObject(sysUser);
		} catch (DaoException e) {
			throw new IllegalArgumentException("add user failed"); 
		}
	}

}
