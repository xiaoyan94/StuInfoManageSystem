package dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import bean.Admin;

public interface AdminDao {
	void saveAdmin(Admin admin);

	Admin getAdmin(DetachedCriteria dc);

	List<Admin> getAdminList(DetachedCriteria dc);

	void update(Admin admin);

	void deleteAdmin(Admin admin);
}
