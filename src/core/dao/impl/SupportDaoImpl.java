package core.dao.impl;
/******************************************************************
 * @summary:
 * 		用于完成DAO操作的抽象基类，主要用于继承
 ******************************************************************/
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import core.dao.SupportDao;


public abstract class SupportDaoImpl<T>  implements SupportDao<T> {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	//构造时初始（获取泛型）
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public SupportDaoImpl(){
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
	}
	
	public void saveEntry(T t) {
		this.getHibernateTemplate().save(t);
	}

	public void updateEntry(T t) {
		this.getHibernateTemplate().update(t);
	}

	public void saveOrUpdateEntry(T t) {
		this.saveOrUpdateEntry(t);
	}

	public int batchByHQL(String hql, Object... objects) {
		Query query = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
		for(int i = 0 ; i < objects.length ; i ++){
			query.setParameter(i, objects[i]);
		}
		return query.executeUpdate();
	}

	public void deleteEntryById(T t) {
		this.deleteEntryById(t);
	}

	public T loadEntry(String id) {
		return this.getHibernateTemplate().load(clazz, id);
	}

	public T getEntry(String id) {
		return this.getHibernateTemplate().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> getEntryListByHQL(String hql,Object ...objects) {
		
		Query query = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
		for(int i = 0 ; i < objects.length ; i ++){
			query.setParameter(i, objects[i]);
		}
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<T> getEntryListBySQL(String sql,Object ...objects) {
		SQLQuery q =  this.getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(sql);
		//添加实体类
		if(clazz != null){
			q.addEntity(clazz);
		}
		for(int i = 0 ; i < objects.length ; i ++){
			q.setParameter(i, objects[i]);
		}
		return q.list();
	}

}
