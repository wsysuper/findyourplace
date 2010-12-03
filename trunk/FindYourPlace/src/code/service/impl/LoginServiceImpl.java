package code.service.impl;

import code.dao.UserDao;
import code.model.User;
import code.service.LoginService;

public class LoginServiceImpl implements LoginService {
	private UserDao userDao;
	
	public UserDao getUserDao() { return this.userDao; }
	public void setUserDao(UserDao userDao) { this.userDao = userDao;}
	
	public int validate(User user) {
		// TODO Auto-generated method stub
		return userDao.validate(user);
	}
}
