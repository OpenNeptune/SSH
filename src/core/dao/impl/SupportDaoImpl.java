package core.dao.impl;
/******************************************************************
 * @summary:
 * 		用于完成DAO操作的抽象基类，主要用于继承
 ******************************************************************/
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

import core.dao.SupportDao;


public abstract class SupportDaoImpl<T>  implements SupportDao<T> {
	
	@Resource(name="hibernateTemplate")
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
		hibernateTemplate.save(t);
	}

	public void updateEntry(T t) {
		hibernateTemplate.update(t);
	}

	public void saveOrUpdateEntry(T t) {
		hibernateTemplate.saveOrUpdate(t);
	}

	@SuppressWarnings("unchecked")
	public int batchByHQL(String hql, Object... objects) {
		 List<T> list = (List<T>) hibernateTemplate.find(hql,objects);
		return list.size();
	}

	public void deleteEntryById(T t) {
		hibernateTemplate.delete(t);
	}

	public T loadEntry(String id) {
		return hibernateTemplate.load(clazz, id);
	}

	public T getEntry(String id) {
		return hibernateTemplate.get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> getEntryListByHQL(String hql,Object ...objects) {
		List<T> list = (List<T>) hibernateTemplate.find(hql,objects);
//		Query query = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
//		for(int i = 0 ; i < objects.length ; i ++){
//			query.setParameter(i, objects[i]);
//		}
//		return query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<T> getEntryListBySQL(String sql,Object ...objects) {
		//如果没有开启事务管理，在线程中不允许获取session
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

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findEntityByHQL(String hql, Object[] objects) {
		return (List<T>) hibernateTemplate.find(hql,objects);
	}
}
