package service;

import java.util.List;

import bean.Admin;

public interface AdminService {
	void saveAdmin(Admin admin);
	/**
	 * 普通管理员
	 * @return
	 */
	Admin getAdminByUsernameAndPasswd(String username,String password);
	/**
	 * 系统管理员
	 * @return
	 */
	Admin getSysAdminByUsernameAndPasswd(String username,String password);
	void deleteAdminById(Long id);
	boolean isExistAdmin(String username);
	List<Admin> getAdminList();
	Admin getAdminById(Long id);
	boolean updateAdmin(Admin admin);
}
