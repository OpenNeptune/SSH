package core.service;

import java.util.List;

import core.model.EntryPage;

public interface SupportService<T> {
	//业务层的操作
	public void save(T t);
	
	public void update(T t);
	
	public void saveOrUpdate(T t);
	
	public int 	batchByHQL(String hql,Object ...objects);
	
	public void delete(T t);
	
	public T load(Integer id);
	
	public T get(Integer id);
	
	public List<T> getListByHQL(String hql,Object ...objects);
	
	public List<T> getListBySQL(String sql,Object ...objects);
	
	public EntryPage query(final String hql, int page, final int size);
}
