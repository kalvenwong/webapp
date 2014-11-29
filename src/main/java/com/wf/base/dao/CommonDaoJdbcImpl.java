package com.wf.base.dao;

import java.io.Serializable;
import java.sql.Types;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


public class CommonDaoJdbcImpl extends JdbcDaoSupport implements CommonDaoJdbc {
	private static Logger log = Logger.getLogger(CommonDaoJdbcImpl.class);
	
	public List getList(String sql) {

		return this.getJdbcTemplate().queryForList(sql);
	}
	
	/**
	 * select * from aa where a =? and b =?
	 * 返回list,list 当中对象为 org.apache.commons.collections.map.ListOrderedMap
	 * @param sql
	 * @param args 参数值
	 * @return
	 */
	public List  getList(String sql,Object [] args){
		return this.getJdbcTemplate().queryForList(sql, args);
	}
	
	/**
	 *
	 * @param sql
	 * @param args 参数
	 * @param argTypes 参数类别[Types.INTEGER;Types.DOUBLE;Types.DATE;Types.VARCHAR;]
	 * @return
	 */
	public List getList(String sql,Object [] args,int [] argTypes){
		return this.getJdbcTemplate().queryForList(sql, args, argTypes);
	}
	
	public Object getObject(String sql,Object [] args,Class requiredType) {
		return this.getJdbcTemplate().queryForObject(sql, args, requiredType);
	}
	
	public Object getObject(String sql,Class requiredType) {
		return this.getJdbcTemplate().queryForObject(sql, requiredType);
	}

	public Object getObject(Object o, Serializable pk) {
		return null;
	}

	public void removeObject(String selectQuery) {
		this.getJdbcTemplate().execute(selectQuery);
	}

	public void removeObject(Object o, Serializable pk) {

	}

	public void saveObject(Object o) {
	

	}

	public void updateObject(Object o) {

	}
	
	public void executeSql(String sql){
		this.getJdbcTemplate().execute(sql);
	}
	
	public int executeSqlUpdate(String sql, Object[] args){
		return this.getJdbcTemplate().update(sql, args);
	}

}
