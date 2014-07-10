package app.dao.impl;


import org.springframework.stereotype.Repository;

import app.model.User;
import core.dao.impl.SupportDaoImpl;

@Repository("UserDao")
public class UserDaoImpl extends SupportDaoImpl<User> {

}
