package web.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import bean.Admin;
import service.AdminService;
import service.StudentService;

public class AdminAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private AdminService adminService;
	private StudentService stuService;
	//---------------添加管理员表单属性开始
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String username;
	private String password;
	private String adminRealName;
	private String tel;
	private Character sex;
	private String email;
	private Map<String,Object> dataMap = new HashMap<>();
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
	public String getAdminRealName() {
		return adminRealName;
	}
	public void setAdminRealName(String adminRealName) {
		this.adminRealName = adminRealName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Character getSex() {
		return sex;
	}
	public void setSex(Character sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//---------------表单属性结束
	public String toLogin() throws Exception {
		return "toLogin";
	}
	/**
	 * 转发提示消息用的
	 * 
	 * 此时若刷新页面 由于是发起一次新的HTTP请求
	 * 所以会新建一个Action实例，则ActionContext中无上次放进去的msg
	 * @return
	 */
	public String show() {
		String msg  = (String) ActionContext.getContext().getSession().get("msg");
		String role  = (String) ActionContext.getContext().getSession().get("role");
		String username  = (String) ActionContext.getContext().getSession().get("username");
		ActionContext.getContext().put("msg", msg);
		ActionContext.getContext().put("role", role);
		ActionContext.getContext().put("username", username);
		ActionContext.getContext().getSession().remove("msg");
		ActionContext.getContext().getSession().remove("role");
		ActionContext.getContext().getSession().remove("username");
		//准备adminList数据
		getAdminList();
		return "SysAdminHome";
	}
	private void getAdminList() {
		List<Admin> adminList =  adminService.getAdminList();
		ActionContext.getContext().put("adminList", adminList);
	}
	
	public String get() throws Exception{
		setDataMap(new HashMap<String, Object>());  
		Admin admin = adminService.getAdminById(id);
		getDataMap().put("admin", admin);
		getDataMap().put("status", "success");
		System.out.println(getDataMap());
		return "adminJson";
	}
	
	public String update() throws Exception{
		Admin admin = new Admin();
		admin.setAdminId(id);
		admin.setAdminEmail(email);
		admin.setAdminName(username);
		admin.setAdminPasswd(password);
		admin.setAdminRealName(adminRealName);
		admin.setAdminTel(tel);
		admin.setAdminRole(Admin.ADMIN);
		admin.setSex(sex);
		boolean b = adminService.updateAdmin(admin);
		if(b) {
			ActionContext.getContext().getSession().put("msg", "更新成功！");
		}else {
			ActionContext.getContext().getSession().put("msg", "更新失败！");
		}
		return "toShow";
	}
	
	public String save() throws Exception{
		String result = "";
		String msg = "";
		boolean existAdmin = adminService.isExistAdmin(username);
		if(existAdmin) {
			msg = "添加失败:用户名已存在！";
		}else {
			Admin admin = new Admin();
			admin.setAdminEmail(email);
			admin.setAdminName(username);
			admin.setAdminPasswd(password);
			admin.setAdminRealName(adminRealName);
			admin.setAdminTel(tel);
			admin.setAdminRole(Admin.ADMIN);
			admin.setSex(sex);
			adminService.saveAdmin(admin );
			msg = "添加成功咯";
		}
		/**
		 * 把提示消息放进Session中，重定向到show方法
		 * 在show方法中取出提示消息并放入ActionContext中
		 * 之后移除Session中的提示消息
		 * 最后从show方法中转发到userManage.jsp
		 * 
		 */
		ActionContext.getContext().getSession().put("msg", msg);
		result = "toShow";
		return result;
	}
	
	public String delete() throws Exception{
		try {
			adminService.deleteAdminById(id);
			ActionContext.getContext().getSession().put("msg", "删除成功！");
		} catch (Exception e) {
			ActionContext.getContext().getSession().put("msg", "删除失败！");
			e.printStackTrace();
		}
		return "toShow";
	}
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public Map<String,Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String,Object> dataMap) {
		this.dataMap = dataMap;
	}

	public StudentService getStuService() {
		return stuService;
	}

	public void setStuService(StudentService stuService) {
		this.stuService = stuService;
	}
}
