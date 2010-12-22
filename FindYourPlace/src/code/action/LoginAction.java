package code.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import code.model.User;
import code.service.LoginService;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user;
	private LoginService loginService;
	private String loginResult;
	
	public User getUser() { return user; }
	public void setUser(User user) { this.user = user; }
	
	public void setLoginService(LoginService loginService) { this.loginService = loginService; }
    public LoginService getLoginService() { return this.loginService; }
    
	public String getLoginResult() {return loginResult;}
	public void setLoginResult(String result) {this.loginResult = result;}
	
	public void validate(){
		if(user.getUserName() == null || user.getUserName().trim().equals("")){
			addFieldError("user.userName",getText("name.required"));
		}
		if(user.getUserPassword() == null || user.getUserPassword().trim().equals("")){
			addFieldError("user.userPassword",getText("passwd.required"));
		}
	}
	public String execute() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		int result = loginService.validate(user);
		switch(result){
		case 0:{ 
			//用户登录成功
			session.setAttribute("user", user.getUserName());
			return SUCCESS;
		}
		case 1:{
			//管理员登录成功
			return SUCCESS;
		}
		case 2:{
			//登录失败
			loginResult=getText("login.error");
			return INPUT;
		}
		}
		return INPUT;
	}
}

