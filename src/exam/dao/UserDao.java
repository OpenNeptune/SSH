package exam.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import exam.model.User;

public class UserDao extends HibernateDaoSupport {
	public void add(User user){
		this.getHibernateTemplate().save(user);
	}
}
