package code.dao.hibernate;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import code.dao.AnswerDao;
import code.model.Answer;
import code.model.Question;

import java.util.*;
public class AnswerDaoHibernate extends HibernateDaoSupport implements AnswerDao {

	public boolean addAnswer(Answer answer) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(answer);
		return true;
	}	
	public Question getQuestion(int questionID) {
		// TODO Auto-generated method stub
		List result = this.getHibernateTemplate().
			find("from Question q where q.questionID = " + questionID);
		if (result.size() == 0) return null;
		else return (Question)result.get(0);
	}
	public List getAnswerList(int questionID) {
		// TODO Auto-generated method stub
		List result = this.getHibernateTemplate().
			find("from Answer a where a.question.questionID = " + questionID);
		if (result.size() == 0) return null;
		else return result;
	}
}
