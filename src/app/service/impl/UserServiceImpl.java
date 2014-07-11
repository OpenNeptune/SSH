package app.service.impl;



import org.springframework.stereotype.Service;

import app.model.User;
import app.service.UserService;
import core.service.impl.SupportServiceImpl;

@Service("userService")
public class UserServiceImpl extends SupportServiceImpl<User> implements UserService{
	
	@Override
	public void saveEntry(User user) {
		user.setRecordid(System.currentTimeMillis());
		user.setUserid("1000");
		super.saveEntry(user);
	}

}
