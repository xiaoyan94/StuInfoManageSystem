package bean;

public class Admin {
	public static final int ADMIN = 0;
	public static final int SYS_ADMIN = 1;
	private Long adminId;
	private String adminPasswd;
	private Character sex;
	private String adminTel;
	private String adminName;//登录用户名
	private String adminRealName;//真实姓名
	private String adminEmail;
	private int adminRole;//0普通管理员  1系统管理员
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public Long getAdminId() {
		return adminId;
	}
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
	public String getAdminPasswd() {
		return adminPasswd;
	}
	public void setAdminPasswd(String adminPasswd) {
		this.adminPasswd = adminPasswd;
	}
	public String getAdminTel() {
		return adminTel;
	}
	public void setAdminTel(String adminTel) {
		this.adminTel = adminTel;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminPasswd=" + adminPasswd + ", sex=" + sex + ", adminTel=" + adminTel
				+ ", adminName=" + adminName + ", adminRealName=" + adminRealName + ", adminEmail=" + adminEmail
				+ ", adminRole=" + adminRole + "]";
	}
	public int getAdminRole() {
		return adminRole;
	}
	public void setAdminRole(int adminRole) {
		this.adminRole = adminRole;
	}
	public Character getSex() {
		return sex;
	}
	public void setSex(Character sex) {
		this.sex = sex;
	}
	public String getAdminRealName() {
		return adminRealName;
	}
	public void setAdminRealName(String adminRealName) {
		this.adminRealName = adminRealName;
	}
	
}
