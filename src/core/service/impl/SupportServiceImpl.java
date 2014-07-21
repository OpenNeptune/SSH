package core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import core.dao.SupportDao;
import core.model.EntryPage;
import core.service.SupportService;

@SuppressWarnings({ "unchecked", "rawtypes" })
public abstract class SupportServiceImpl<T> implements SupportService<T> {
	
		public Logger log = Logger.getLogger(this.getClass());
	
		
		private SupportDao supportDao;
		
		@Resource
		public void setSupportDao(SupportDao supportDao) {
			this.supportDao = supportDao;
		}

		@Override
		public void save(T t) {
			supportDao.saveEntry(t);
		}

		@Override
		public void update(T t) {
			supportDao.updateEntry(t);
		}

		@Override
		public void saveOrUpdate(T t) {
			supportDao.saveOrUpdateEntry(t);
		}

		@Override
		public int batchByHQL(String hql, Object... objects) {
			return supportDao.batchEntryByHQL(hql, objects);
		}

		@Override
		public void delete(T t) {
			supportDao.deleteEntryById(t);
		}

		@Override
		public T load(Integer id) {
			return (T) supportDao.loadEntry(id);
		}

		@Override
		public T get(Integer id) {
			return (T) supportDao.getEntry(id);
		}

		@Override
		public List<T> getListByHQL(String hql, Object... objects) {
			return supportDao.getEntryListByHQL(hql, objects);
		}

		@Override
		public List<T> getListBySQL(String sql, Object... objects) {
			return supportDao.getEntryListBySQL(sql, objects);
		}

		@Override
		public EntryPage query(String hql, int page, int size) {
			return supportDao.queryEntry(hql, page, size);
		}


}
