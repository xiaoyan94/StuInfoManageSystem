package service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import bean.Admin;
import dao.AdminDao;
import service.AdminService;
/**
 * 一定要打开事务
 * @author yan
 *
 */
@Transactional
public class AdminServiceImpl implements AdminService {
	private AdminDao adminDao;
	@Override
	public boolean isExistAdmin(String username) {
		DetachedCriteria dc = DetachedCriteria.forClass(Admin.class);
		dc.add(Restrictions.eq("adminName", username));
		Admin admin = adminDao.getAdmin(dc );
		return admin != null?true:false;
	}
	
	@Override
	public void saveAdmin(Admin admin) {
		adminDao.saveAdmin(admin);
	}
	@Override
	public Admin getAdminById(Long id) {
		DetachedCriteria dc = DetachedCriteria.forClass(Admin.class);
		dc.add(Restrictions.eq("adminId",id));
		return adminDao.getAdmin(dc);
	}

	@Override
	public Admin getAdminByUsernameAndPasswd(String username, String password) {
		DetachedCriteria dc = DetachedCriteria.forClass(Admin.class);
		dc.add(Restrictions.eq("adminName", username));
		dc.add(Restrictions.eq("adminPasswd", password));
		dc.add(Restrictions.eq("adminRole", 0));
		return adminDao.getAdmin(dc);
	}

	@Override
	public Admin getSysAdminByUsernameAndPasswd(String username, String password) {
		DetachedCriteria dc = DetachedCriteria.forClass(Admin.class);
		dc.add(Restrictions.eq("adminName", username));
		dc.add(Restrictions.eq("adminPasswd", password));
		dc.add(Restrictions.eq("adminRole", 1));
		return adminDao.getAdmin(dc);
	}

	@Override
	public void deleteAdminById(Long id) {
		DetachedCriteria dc = DetachedCriteria.forClass(Admin.class);
		dc.add(Restrictions.eq("adminId", id));
		Admin admin = adminDao.getAdmin(dc );
		adminDao.deleteAdmin(admin);
	}

	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public List<Admin> getAdminList() {
		DetachedCriteria dc = DetachedCriteria.forClass(Admin.class);
		dc.add(Restrictions.eq("adminRole", Admin.ADMIN));
		List<Admin> adminList = adminDao.getAdminList(dc );
		return adminList;
	}

	@Override
	public boolean updateAdmin(Admin admin) {
		try {
			adminDao.update(admin);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
