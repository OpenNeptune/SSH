package core.dao.impl;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import core.dao.SupportDao;
import core.model.EntryPage;
/******************************************************************
 * @summary:
 * 		用于完成DAO操作的抽象基类，主要用于继承
 ******************************************************************/

public abstract class SupportDaoImpl<T> implements   SupportDao<T> {
	
	@Resource(name="hibernateTemplate")
	@Getter @Setter private HibernateTemplate hibernateTemplate;
	
	//构造时初始（获取泛型）
	@Getter @Setter private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public SupportDaoImpl(){
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
	}

	@Override
	public void saveEntry(T t) {
		this.hibernateTemplate.save(t);
	}

	@Override
	public void updateEntry(T t) {
		this.hibernateTemplate.update(t);
	}

	@Override
	public void saveOrUpdateEntry(T t) {
		this.hibernateTemplate.saveOrUpdate(t);
	}

	@Override
	@SuppressWarnings("unchecked")
	public int batchEntryByHQL(String hql, Object... objects) {
		List<T> list = (List<T>) hibernateTemplate.find(hql,objects);
		return list.size();
	}

	@Override
	public void deleteEntryById(T t) {
		hibernateTemplate.delete(t);
	}

	@Override
	public T loadEntry(Integer id) {
		return hibernateTemplate.load(clazz, id);
	}

	@Override
	public T getEntry(Integer id) {
		return hibernateTemplate.get(clazz, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> getEntryListByHQL(String hql, Object... objects) {
		List<T> list = (List<T>) hibernateTemplate.find(hql,objects);
		return list;
	}

	
	@Override
	@SuppressWarnings("unchecked")
	public List<T> getEntryListBySQL(String sql, Object... objects) {
		//如果没有开启事务管理，在线程中不允许获取session
		SQLQuery q =  hibernateTemplate.getSessionFactory().getCurrentSession().createSQLQuery(sql);
		//添加实体类
		if(clazz != null){
			q.addEntity(clazz);
		}
		for(int i = 0 ; i < objects.length ; i ++){
			q.setParameter(i, objects[i]);
		}
		return q.list();
	}

	
	@Override
	@SuppressWarnings("unchecked")
	public List<T> findEntityByHQL(String hql, Object[] objects) {
		return (List<T>) hibernateTemplate.find(hql,objects);
	}

	/**
	 * page默认值为1. 从第一页开始
	 * size默认值为100,每页100条记录
	 */
	@Override
	@SuppressWarnings({ "unchecked", "deprecation","rawtypes" })
	public EntryPage queryEntry(final String hql, int page, final int size) {
		final EntryPage pageInfo = new EntryPage();
		pageInfo.setPageSize(size);
		pageInfo.setCurrentPage(page);
		pageInfo.setAllRow(hibernateTemplate.find(hql).size());
		pageInfo.init();
		List<Object> list = (List<Object>) hibernateTemplate.executeFind(new HibernateCallback(){
	            public Object doInHibernate(Session session) throws HibernateException,SQLException{
	                Query query = session.createQuery(hql);
	                query.setFirstResult(pageInfo.getOffset());
	                query.setMaxResults(size);
					List list = query.list();
	                return list;
	            }
	    });
		pageInfo.setList(list);
		pageInfo.init();
		return pageInfo;
	}
	

}
