package core.dao;

import java.util.List;
import core.model.EntryPage;
/****
 * 
 * @Summary
 * 		定义统一的DAO操作的API接口
 * @注意：
 * 		DAO层的API其命名方式都包括“Entry”标识符以表明該操作属于DAO层
 * 		另外：LoadEntry和getEntry参数的类型都是业务实体的主键类型
 * @param <T>
 */
public interface SupportDao<T> {
	
	public void saveEntry(T t);
	
	public void updateEntry(T t);
	
	public void saveOrUpdateEntry(T t);
	
	public int batchEntryByHQL(String hql,Object ...objects);
	
	public void deleteEntryById(T t);
	
	public T loadEntry(Integer id);
	
	public T getEntry(Integer id);
	
	public List<T> getEntryListByHQL(String hql,Object ...objects);
	
	public List<T> getEntryListBySQL(String sql,Object ...objects);

	public List<T> findEntityByHQL(String hql, Object[] objects);
	
	public EntryPage queryEntry(final String hql, int page, final int size);
}
