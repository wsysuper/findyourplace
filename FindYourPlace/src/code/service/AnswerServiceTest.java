package code.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import code.model.Answer;
import code.model.Question;
import code.model.User;
import junit.framework.TestCase;

public class AnswerServiceTest extends TestCase {
	ApplicationContext context = new FileSystemXmlApplicationContext("D:\\applicationContext.xml");
	private AnswerService as;
	private User user;
	private Question question;
	private Answer answer;
	protected void setUp() throws Exception {
		super.setUp();
		as = (AnswerService)context.getBean("AnswerServiceProxy");
		user = new User();
		user.setUserName("cy");
		user.setUserPassword("1");
		question = new Question();
		question.setContent("试试看中文~~");
		question.setTitle("why");
		answer=new Answer();
		answer.setUser(user);
		answer.setQuestion(question);
		answer.setContent("you are clever");
	}
    public void testAddAnswer() {
    	assertEquals(as.addAnswer(question, user,answer), true);
    }
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
