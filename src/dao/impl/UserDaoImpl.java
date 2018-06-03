package dao.impl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import bean.User;
import dao.UserDao;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public void add(User u) {
		getHibernateTemplate().save(u);
	}


}
