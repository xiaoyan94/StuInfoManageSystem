package service.impl;

import org.springframework.transaction.annotation.Transactional;

import bean.User;
import dao.UserDao;
import service.UserService;
@Transactional
public class UserServiceImpl implements UserService {
	private UserDao userDao;
	
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void add(User u) {
		userDao.add(u);
	}

}
