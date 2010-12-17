package code.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import code.model.Question;
import code.model.User;
import junit.framework.TestCase;

public class QuestionServiceTest extends TestCase {
	ApplicationContext context = new FileSystemXmlApplicationContext("D:\\applicationContext.xml");
	private QuestionService qs;
	private User user;
	private Question question;
	
	protected void setUp() throws Exception {
		super.setUp();
		qs = (QuestionService)context.getBean("QuestionServiceProxy");
		user = new User();
		user.setUserName("bol");
		question = new Question();
		question.setTitle("why");
		question.setContent("试试看中文~~");
	}
    public void testAddQuestion() {
    	assertEquals(qs.addQuestion(question, user), true);
    }
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
