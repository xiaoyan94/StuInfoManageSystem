package web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import bean.Classes;
import bean.College;
import bean.Profession;
import bean.Student;
import bean.User;
import service.UserService;

public class UserLoginAction extends ActionSupport implements ModelDriven<User>{
	private UserService userService;
	private User user = new User();
	private static final long serialVersionUID = 1L;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Override
	public String execute() throws Exception {
		userService.add(user);
		Student stu = new Student();
		stu.setIdCard("34122618923434");
		stu.setName("Name222");
		stu.setSex('男');
		stu.setTel("111111111111");
		Classes classes = new Classes();
		classes.setName("XXXXXXXXXXXX2班");
		College college = new College();
		college.setName("XXX学院");
		Profession profession = new Profession();
		profession.setName("XX专业");
		profession.setCollege(college);
		//classes.setCollege(college);
		classes.setProfession(profession);
		stu.setClasses(classes );
		
		return SUCCESS;
	}
	@Override
	public User getModel() {
		return user;
	}
}
