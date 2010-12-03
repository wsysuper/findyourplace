package code.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import code.model.User;

import junit.framework.TestCase;

public class LoginServiceTest extends TestCase {
	ApplicationContext context = new FileSystemXmlApplicationContext("D:\\applicationContext.xml");
	private LoginService ls;
	private User user;

	protected void setUp() throws Exception {
		super.setUp();
		ls = (LoginService)context.getBean("LoginServiceProxy");
		user = new User();
		user.setUserName("pan");
		user.setUserPassword("111111");
	}

	public void testAddQuestion() {
    	assertEquals(ls.validate(user), 1);
    }
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
