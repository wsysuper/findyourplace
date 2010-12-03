package code.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import code.dao.UserDao;
import code.model.User;

public class UserDaoHibernate extends HibernateDaoSupport implements UserDao{

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
}
