package core.dao.impl;



import org.springframework.stereotype.Repository;

import core.dao.UserDao;
import core.model.User;

@Repository("userDao")
public class UserDaoImpl extends SupportDaoImpl<User> implements UserDao{

}
