package code.dao.hibernate;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import code.dao.QuestionDao;
import code.model.Question;
public class QuestionDaoHibernate extends HibernateDaoSupport implements QuestionDao {

	public boolean addQuestion(Question question) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(question);
		return true;
	}	
	
	public List getPreFoundQuestionList(String content){
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().openSession().createCriteria(Question.class);
		criteria.add(Restrictions.like("content", "%"+content+"%"));
		criteria.setMaxResults(20);
		if(criteria == null)
			return null;
		List list = criteria.list();
		List result = list;
		return result;
	}
	

	public List getBlurFoundQuestionList(String content){
		List<Question> result = new ArrayList<Question>();
		String[] strs = content.split(" ");
		System.out.println(content);
		System.out.println("in QuestionDaoHibernate\n");
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().openSession().createCriteria(Question.class);
		criteria.setMaxResults(20);
		if(criteria == null)
			System.out.println("criteria null\n");
		for(int i = 0;i < strs.length;i++)
		{
			System.out.println(strs[i]);
			System.out.print(i);
			if(criteria == null)
				System.out.println("criteria is null\n");
			criteria.add(Restrictions.like("content", "%"+strs[i]+"%"));
			criteria.setMaxResults(20);
			List list = criteria.list();
			if(list.size() == 0)
				System.out.println("list is null\n");
//			if(i == 0)
//				result = list;
//			else
			System.out.println("list: " + list.size());
			result.addAll(list);
			System.out.println("result: " + result.size());
		}
		if(result.size() == 0)
			System.out.println("result set in hibernate is null\n");
		return result;
	}

	public Question getQuestion(int questionID) {
		// TODO Auto-generated method stub
		List result = this.getHibernateTemplate().
			find("from Question q where q.questionID = " + questionID);
		if (result.size() == 0) return null;
		else return (Question)result.get(0);
	}

	public List<Question> getLatestQuestion(int millisec) {
		// TODO Auto-generated method stub
		Date pubDate = new Date(System.currentTimeMillis() - millisec);
		List result = this.getHibernateTemplate().find("from Question q where q.pubDate > '" + pubDate + "'");
		return result;
	}
}
