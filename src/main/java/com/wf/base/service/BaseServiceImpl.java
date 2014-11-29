package com.wf.base.service;

import com.wf.base.dao.CommonDao;
import com.wf.exception.DaoException;


public class BaseServiceImpl implements BaseService {
	protected  CommonDao commonDao;


	public void saveObject(Object o) throws DaoException {
		commonDao.addObject(o);
	}


	public CommonDao getCommonDao() {
		return commonDao;
	}

	public void setCommonDao(CommonDao commonDao) {
		this.commonDao = commonDao;
	}
	

}
