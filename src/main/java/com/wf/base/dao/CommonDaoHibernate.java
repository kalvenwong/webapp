package com.wf.base.dao;

import java.io.Serializable;
import java.util.Map;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.wf.exception.DaoException;


public class CommonDaoHibernate implements CommonDao {
	
	protected Logger log = Logger.getLogger(CommonDao.class);  
	  
    
    private SessionFactory sessionFactory;  
  
     
    public void addObject(Object obj) throws DaoException{  
        log.debug("BaseDao addObject object " + obj);  
        try{  
            sessionFactory.getCurrentSession().save(obj);  
        }catch(Exception e){  
            throw new DaoException("根据传入对象添加记录异常，请联系管理员！",e);  
        }  
    }  
  
     
    public void dbFlush() throws DaoException{  
        log.debug("BaseDao addObject dbFlush");  
        try{  
            sessionFactory.getCurrentSession().flush();  
        }catch(Exception e){  
            throw new DaoException("刷新缓存失败，请联系管理员！",e);  
        }  
    }  
  
     
    public String addObjectPK(Object obj) throws DaoException{  
        log.debug("BaseDao addObjectPK object " + obj);  
        String id = null;  
        try{  
            id = (String) sessionFactory.getCurrentSession().save(obj);  
        }catch(Exception e){  
            throw new DaoException("根据传入对象添加记录异常，请联系管理员！",e);  
        }  
        return id;  
    }  
  
     
    public void deleteObject(Object obj) throws DaoException{  
        log.debug("BaseDao deleteObject object " + obj);  
        try{  
            sessionFactory.getCurrentSession().delete(obj);  
        }catch(Exception e){  
            throw new DaoException("根据传入对象删除记录异常，请联系管理员！",e);  
        }  
    }  
  
     
    @SuppressWarnings({"rawtypes"})  
    public void deleteObject(Class cls,Serializable id) throws DaoException{  
        log.debug("BaseDao deleteObject Class " + cls.getName() + " id " + id.toString());  
        try{  
            this.deleteObject(sessionFactory.getCurrentSession().get(cls,id));  
        }catch(Exception e){  
            throw new DaoException("根据传入对象与ID删除记录异常，请联系管理员！",e);  
        }  
    }  
  
     
    public void updateObject(Object obj) throws DaoException{  
        log.debug("BaseDao updateObject object " + obj);  
        try{  
            sessionFactory.getCurrentSession().update(obj);  
        }catch(Exception e){  
            throw new DaoException("根据传入对象更新记录异常，请联系管理员！");  
        }  
    }  
  
     
    public String updateObjectPK(Object obj) throws DaoException{  
        log.debug("BaseDao updateObjectPK object " + obj);  
        String id = null;  
        try{  
            id = this.addObjectPK(obj);  
        }catch(Exception e){  
            throw new DaoException("根据传入对象更新记录异常，请联系管理员！",e);  
        }  
        return id;  
    }  
  
     
    public void addOrUpdate(Object obj) throws DaoException{  
        log.debug("BaseDao updateObjectPK object " + obj);  
        try{  
            sessionFactory.getCurrentSession().saveOrUpdate(obj);  
        }catch(Exception e){  
            throw new DaoException("根据传入对象保存数据异常，请联系管理员！",e);  
        }  
    }  
  
     
    @SuppressWarnings({"rawtypes"})  
    public Object findObjectById(Class cls,Serializable id) throws DaoException{  
        log.debug("BaseDao findObjectById Class " + cls.getName() + " id " + id.toString());  
        Object obj = null;  
        try{  
            obj = sessionFactory.getCurrentSession().get(cls,id);  
        }catch(Exception e){  
            throw new DaoException("根据对象及ID查询记录异常，请联系管理员！",e);  
        }  
        return obj;  
    }  
  
     
    @SuppressWarnings({"rawtypes"})  
    public List findAllData(Class cls) throws DaoException{  
        log.debug("BaseDao findAllData Class " + cls.getName());  
        List list = null;  
        try{  
            list = sessionFactory.getCurrentSession().createQuery(" from " + cls.getName() + "").list();  
        }catch(Exception e){  
            throw new DaoException("根据对象查询记录异常，请联系管理员！",e);  
        }  
        return list;  
    }  
  
     
    @SuppressWarnings("rawtypes")  
    public List findHQLObject(String hql) throws DaoException{  
        try{  
            return sessionFactory.getCurrentSession().createQuery(hql).list();  
        }catch(Exception e){  
            throw new DaoException("根据传入条件语句查询记录异常，请联系管理员！");  
        }  
    }  
  
     
//    @SuppressWarnings("rawtypes")  
//    public List findListByHqlName(IHqlProviderSet hqlProviderSet,String queryName,Map paramMap) throws DaoException{  
//        String hql;  
//        try{  
//            hql = hqlProviderSet.getHqlByQryName(queryName);  
//            Query query = sessionFactory.getCurrentSession().createQuery(hql);  
//            if(paramMap != null){  
//                hqlArgs(paramMap,query);  
//            }  
//  
//            return query.list();  
//        }catch(Exception e){  
//            throw new DaoException("按HQL提供者别名与条件查询集合异常，请联系管理员！",e);  
//        }  
//    }  
  
     
//    @SuppressWarnings("rawtypes")  
//    public List findListByHqlName(IHqlProviderSet hqlProviderSet,String queryName,Map paramMap,PageEntity page) throws DaoException{  
//        String hql;  
//        try{  
//            hql = hqlProviderSet.getHqlByQryName(queryName);  
//  
//            Query query = sessionFactory.getCurrentSession().createQuery(hql);  
//  
//            if(paramMap != null){  
//                hqlArgs(paramMap,query);  
//            }  
//  
//            query.setFirstResult((page.getPageNo() - 1) * page.getPageSize());  
//            query.setMaxResults(page.getPageSize());  
//  
//            return query.list();  
//        }catch(Exception e){  
//            throw new DaoException("按HQL提供者别名、条件、分页信息查询集合异常，请联系管理员！",e);  
//        }  
//    }  
  
     
    @SuppressWarnings("rawtypes")  
    public int findIntRowCountByHqlName(Class cls) throws DaoException{  
        try{  
            Query query = sessionFactory.getCurrentSession().createQuery(" select count(c.id) from " + cls.getName() + " c ");  
            List list = query.list();  
            int rowCount = ((Number) list.get(0)).intValue();  
            return rowCount;  
        }catch(Exception e){  
            throw new DaoException("查询记录总数异常，请联系管理员！",e);  
        }  
    }  
  
     
//    @SuppressWarnings("rawtypes")  
//    public int findIntRowCountByHqlName(IHqlProviderSet hqlProviderSet,String queryName,Map paramMap) throws DaoException{  
//        String hql;  
//        try{  
//            hql = hqlProviderSet.getHqlByQryName(queryName);  
//            Query query = sessionFactory.getCurrentSession().createQuery(hql);  
//            if(paramMap != null){  
//                hqlArgs(paramMap,query);  
//            }  
//            List list = query.list();  
//            int rowCount = ((Number) list.get(0)).intValue();  
//            return rowCount;  
//        }catch(Exception e){  
//            throw new DaoException("执行带参数的查询记录总数异常，请联系管理员！",e);  
//        }  
//    }  
  
     
    @SuppressWarnings("rawtypes")  
    public void hqlArgs(Map argsMap,Query query){  
        Iterator itKey = argsMap.keySet().iterator();  
        while(itKey.hasNext()){  
            String key = (String) itKey.next();  
            @SuppressWarnings("unused")  
            Object obj = argsMap.get(key);  
            if(argsMap.get(key) instanceof List){  
                query.setParameterList(key,(List) argsMap.get(key));  
            }else{  
                query.setParameter(key,argsMap.get(key));  
            }  
        }  
    }  
  
    public SessionFactory getSessionFactory(){  
        return sessionFactory;  
    }  
  
    public void setSessionFactory(SessionFactory sessionFactory){  
        this.sessionFactory = sessionFactory;  
    }  
	
}
