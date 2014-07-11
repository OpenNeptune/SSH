package app.dao.impl;



import org.springframework.stereotype.Repository;

import app.dao.UserDao;
import app.model.User;
import core.dao.impl.SupportDaoImpl;

@Repository("userDao")
public class UserDaoImpl extends SupportDaoImpl<User> implements UserDao{

}
