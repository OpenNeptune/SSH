package core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import core.dao.SupportDao;
import core.service.SupportService;

@SuppressWarnings({ "unchecked", "rawtypes" })
public abstract class SupportServiceImpl<T> implements SupportService<T> {
	
		public Logger log = Logger.getLogger(this.getClass());
	
		
		private SupportDao supportDao;
		
		@Resource
		public void setSupportDao(SupportDao supportDao) {
			this.supportDao = supportDao;
		}

		public SupportDao getSupportDao(){
			return this.supportDao;
		}
		
		@Override
		public void saveEntry(T t) {
			supportDao.saveEntry(t);
		}


		@Override
		public void updateEntry(T t) {
			supportDao.updateEntry(t);
		}

		@Override
		public void saveOrUpdateEntry(T t) {
			supportDao.saveOrUpdateEntry(t);
		}

		@Override
		public int batchByHQL(String hql, Object... objects) {
			return supportDao.batchByHQL(hql, objects);
		}

		@Override
		public void deleteEntryById(T t) {
			supportDao.deleteEntryById(t);
		}

		@Override
		public T loadEntry(String id) {
			return (T) supportDao.loadEntry(id);
		}

		@Override
		public T getEntry(String id) {
			return (T) supportDao.getEntry(id);
		}

		@Override
		public List<T> getEntryListByHQL(String hql, Object... objects) {
			return supportDao.getEntryListByHQL(hql, objects);
		}

		@Override
		public List<T> getEntryListBySQL(String sql, Object... objects) {
			return supportDao.getEntryListBySQL(sql, objects);
		}
		
		public List<T> findEntityByHQL(String hql, Object... objects) {
			return supportDao.findEntityByHQL(hql, objects);
		}

}
