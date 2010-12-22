package code.dao;

import code.model.User;

public interface UserDao {
	//用于登录时验证用户是否存在及其类型；返回0表示普通用户，1表示管理员，2表示不存在
	public abstract int validate(User user);
	//用于根据用户名得到用户信息
	public User getUser(String userName);
	//用于扣除用户积分；返回false表示积分不足，扣除失败
	public abstract boolean deductPoint(String userName, int reward);
	//用于给用户积分奖励
	public abstract boolean payReward(String userName, int reward);
}
