package core.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import core.dao.EntryPageDao;
import core.model.EntryPage;

@Repository("entryPageDao")
public class EntryPageDaoImpl implements EntryPageDao{
	
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/**
	 * page默认值为1. 从第一页开始
	 * size默认值为100,每页100条记录
	 */
	@Override
	@SuppressWarnings({ "unchecked", "deprecation","rawtypes" })
	public EntryPage query(final String hql, int page, final int size) {
		final EntryPage pageInfo = new EntryPage();
		pageInfo.setPageSize(size);
		pageInfo.setCurrentPage(page);
		pageInfo.setAllRow(hibernateTemplate.find(hql).size());
		pageInfo.init();
		List<Object> list = (List<Object>) getHibernateTemplate().executeFind(new HibernateCallback(){
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
