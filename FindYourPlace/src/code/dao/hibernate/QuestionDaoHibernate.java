package code.dao.hibernate;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import code.dao.QuestionDao;
import code.model.Question;

public class QuestionDaoHibernate extends HibernateDaoSupport implements QuestionDao {

	public boolean addQuestion(Question question) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(question);
		return true;
	}	
}
