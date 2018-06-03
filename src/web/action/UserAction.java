package web.action;

import com.opensymphony.xwork2.ActionSupport;

import bean.User;
import service.UserService;

public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String add() {
		User user = new User();
		user.setUname(""+Math.random());
		user.setUpasswd(""+Math.random());
		userService.add(user);
		return SUCCESS;
	}
	

}