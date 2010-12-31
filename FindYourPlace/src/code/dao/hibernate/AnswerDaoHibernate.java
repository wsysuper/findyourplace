package code.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import code.dao.AnswerDao;
import code.model.Answer;
import java.util.*;
public class AnswerDaoHibernate extends HibernateDaoSupport implements AnswerDao {

	public boolean addAnswer(Answer answer) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(answer);
		return true;
	}	
	
	public List getPreFoundAnswerList(String content){
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().openSession().createCriteria(Answer.class);
		criteria.add(Restrictions.like("content", "%"+content+"%"));
		criteria.setMaxResults(20);
		if(criteria == null)
			return null;
		List list = criteria.list();
		List result = list;
		return result;
	}
	

	public List getBlurFoundAnswerList(String content){
		List<Answer> result = new ArrayList<Answer>();
		String[] strs = content.split(" ");
		System.out.println(content);
		System.out.println("in AnswerDaoHibernate\n");
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().openSession().createCriteria(Answer.class);
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
}
