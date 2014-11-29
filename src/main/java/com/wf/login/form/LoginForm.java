package com.wf.login.form;

import com.wf.base.form.BaseForm;
import com.wf.model.SysUser;

public class LoginForm extends BaseForm {
	protected SysUser sysUser;

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}
	
	
}
