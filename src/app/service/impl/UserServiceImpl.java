package app.service.impl;



import java.util.List;

import org.springframework.stereotype.Service;

import app.model.User;
import app.service.UserService;
import core.service.impl.SupportServiceImpl;
import core.util.validate;

@Service("userService")
public class UserServiceImpl extends SupportServiceImpl<User> implements UserService{
	/**
	 * 业务层的实现
	 */
	public void save(User user) {
		saveEntry(user);
	}

	@Override
	public boolean isRegisterByName(String username) {
		String hql = "from User u where u.username = ?" ;
		List<User> list = this.findEntityByHQL(hql, username);
		return !validate.isValid(list) ;
	}

	@Override
	public boolean isRegisterByEmail(String email) {
		String hql = "from User u where u.email = ?" ;
		List<User> list = this.findEntityByHQL(hql, email);
		return !validate.isValid(list) ;
	}

	@Override
	public boolean vaildateLogin(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
