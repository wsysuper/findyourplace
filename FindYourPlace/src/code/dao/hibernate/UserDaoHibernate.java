package code.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import code.dao.UserDao;
import code.model.User;

public class UserDaoHibernate extends HibernateDaoSupport implements UserDao{
	//用于登录时验证用户是否存在及其类型；返回0表示普通用户，1表示管理员，2表示不存在
	public int validate(User user) {
		// TODO Auto-generated method stub
		List result = this.getHibernateTemplate().
			find("from User r where r.userName = \'" + user.getUserName() + "\'" +
					" and r.userPassword = \'" + user.getUserPassword() + "\'");
		if(result.size() == 0) return 2;
		User r = (User)result.get(0);

		if(r.isAdmin()) return 1;

		else return 0;
	}

	//用于根据用户名得到用户信息
	public User getUser(String userName) {
		// TODO Auto-generated method stub
		List result = this.getHibernateTemplate().
			find("from User r where r.userName = \'" + userName + "\'");
		if(result.size() == 0) return null;
		User r = (User)result.get(0);

		return r;
	}

	//用于扣除用户积分；返回false表示积分不足，扣除失败
	public boolean deductPoint(String userName, int reward) {
		// TODO Auto-generated method stub
		User user = getUser(userName);
		if (user == null) return false;
		else {
			int userPoint = user.getUserPoint();
			if (userPoint < reward) return false;
			else {
				user.setUserPoint(userPoint - reward);
				this.getHibernateTemplate().update(user);
				return true;
			}
		}
	}

	//用于给用户积分奖励
	public boolean payReward(String userName, int reward) {
		// TODO Auto-generated method stub
		User user = getUser(userName);
		if (user == null) return false;
		else {
			user.setUserPoint(user.getUserPoint() + reward);
			return true;
		}
	}
}
