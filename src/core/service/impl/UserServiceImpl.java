package core.service.impl;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import core.dao.SupportDao;
import core.model.EntryPage;
import core.model.User;
import core.service.UserService;
import core.util.validate;

@Service("userService")
public class UserServiceImpl extends SupportServiceImpl<User> implements UserService{

	
	@SuppressWarnings("rawtypes")
	
	@Override
	@Resource(name="userDao")
	public void setSupportDao(SupportDao supportDao) {
		super.setSupportDao(supportDao);
	}

	@Override
	public boolean isRegisterByName(String userName) {
		String hql = "from User u where u.username = ?" ;
		List<User> list = this.getListByHQL(hql, userName);
		return !validate.isValid(list) ;
	}

	public EntryPage query( int page, int size) {
		String hql ="from User a order by a.userid";
		EntryPage pages = super.query(hql, page, size);
		return pages;
	}

	
	
}
