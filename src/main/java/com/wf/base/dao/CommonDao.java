package com.wf.base.dao;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;

import com.wf.exception.DaoException;


public interface CommonDao {

     
    public void addObject(Object obj) throws DaoException;
  
     
    public void dbFlush() throws DaoException;
  
     
    public String addObjectPK(Object obj) throws DaoException;
  
     
    public void deleteObject(Object obj) throws DaoException;
  
     
    public void deleteObject(Class cls,Serializable id) throws DaoException;
  
     
    public void updateObject(Object obj) throws DaoException;
  
     
    public String updateObjectPK(Object obj) throws DaoException;
  
     
    public void addOrUpdate(Object obj) throws DaoException;
  
     
    public Object findObjectById(Class cls,Serializable id) throws DaoException;
     
    public List findAllData(Class cls) throws DaoException;
     
    public List findHQLObject(String hql) throws DaoException;
     
    public int findIntRowCountByHqlName(Class cls) throws DaoException;
  
     
    public void hqlArgs(Map argsMap,Query query);

}
