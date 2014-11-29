package com.wf.base.dao;

import java.util.List;

public interface CommonDaoJdbc {
	public List getList(String sql);

	public List getList(String sql, Object[] args);

	public List getList(String sql, Object[] args, int[] argTypes);
	
	public Object getObject(String sql,Object [] args,Class requiredType);
	
	public Object getObject(String sql,Class requiredType);
	
	public void executeSql(String sql);
	
	//执行带参数的SQL更新语句
	public int executeSqlUpdate(String sql, Object[] args);
}
