package core.dao;

import java.util.List;

public interface SupportDao<T> {
	
	//DAO层的API
	public void saveEntry(T t);
	
	public void updateEntry(T t);
	
	public void saveOrUpdateEntry(T t);
	
	public int batchByHQL(String hql,Object ...objects);
	
	public void deleteEntryById(T t);
	
	public T loadEntry(String id);
	
	public T getEntry(String id);
	
	public List<T> getEntryListByHQL(String hql,Object ...objects);
	
	public List<T> getEntryListBySQL(String sql,Object ...objects);
	
	
	
}
