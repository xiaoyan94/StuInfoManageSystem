package web.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 统一登录Action
 * @author yan
 *
 */

import bean.Admin;
import bean.Student;
import service.AdminService;
import service.StudentService;
public class LoginAction extends ActionSupport {
	private AdminService adminService;
	private StudentService studentService;
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String role;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * 转发到登录页面，并取出session中的msg
	 * @return
	 * @throws Exception
	 */
	public String loginPage() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Object msg = session.getAttribute("msg");
		session.removeAttribute("msg");
		ActionContext.getContext().put("msg", msg);
		return "login";
	}
	
	public String login() throws Exception {
		String result = ERROR;
		switch (role) {
		case "0":
			try {
				//学生登录
				Student stu = new Student();
				stu.setId(Long.valueOf(username));
				stu.setPasswd(password);
				Student existStu = studentService.findByUsernameAndPasswd(stu);
				if(existStu!=null) {
					ActionContext.getContext().getSession().put("student", existStu);
					ActionContext.getContext().getSession().put("msg", "登录成功");
					result = "toStudentAction";
				}else {
					ActionContext.getContext().getSession().put("msg", "用户名或密码错误");
					result = "toLogin";
				}
			}catch (Exception e) {
				ActionContext.getContext().getSession().put("msg", "用户名或密码错误");
				result = "toLogin";
			}
		case "1":
			//普通管理员登录
			break;
		case "2":
			//系统管理员登录
			Admin existAdmin = adminService.getSysAdminByUsernameAndPasswd(username, password);
			System.out.println(existAdmin);
			if(existAdmin == null) {
				//只在转发时有效
				//this.addActionError("用户名或密码错误！");
				ActionContext.getContext().getSession().put("msg", "用户名或密码错误");
				result = "toLogin";
			}else {
				ActionContext.getContext().getSession().put("user", existAdmin);
				ActionContext.getContext().getSession().put("msg", "登录成功");
				result = "toAdminAction_show";
			}

		default:
			break;
		}
		if("toLogin".equals(result)) {
			//记住选择的登录身份
			ActionContext.getContext().getSession().put("role", role);
			//记住用户名
			ActionContext.getContext().getSession().put("username", username);
		}
		return result;
	}
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

}
