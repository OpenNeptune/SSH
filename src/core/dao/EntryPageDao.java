package core.dao;

import core.model.EntryPage;

/**
 * 
 * @Summary:
 * 		通用的分页查询接口
 *
 */
public interface EntryPageDao {

	/**
	 * @Summary
	 * 		通用的实体分页查询接口
	 * @param hql
	 * @param page
	 * @param size
	 * @return
	 */
	public EntryPage query(String hql,int page,int size);
}
