package dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.util.CollectionUtils;

import bean.Admin;
import dao.AdminDao;

public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao {

	@Override
	public void saveAdmin(Admin admin) {
		Serializable serializable = getHibernateTemplate().save(admin);
		System.out.println("dao.impl.AdminDaoImpl.saveAdmin(Admin):"+serializable);
	}

	@Override
	public Admin getAdmin(DetachedCriteria dc) {
		List<?> findByCriteria = getHibernateTemplate().findByCriteria(dc);
		if(CollectionUtils.isEmpty(findByCriteria)) {
			return null;
		}else {
			return (Admin) findByCriteria.get(0);
		}
	}

	@Override
	public void deleteAdmin(Admin admin) {
		getHibernateTemplate().delete(admin);
	}

	@Override
	public List<Admin> getAdminList(DetachedCriteria dc) {
		@SuppressWarnings("unchecked")
		List<Admin> list = (List<Admin>) getHibernateTemplate().findByCriteria(dc);
		return list;
	}

	@Override
	public void update(Admin admin) {
		getHibernateTemplate().update(admin);
	}

	@Override
	public Admin load(Long id) {
		return getHibernateTemplate().execute(new HibernateCallback<Admin>() {
			@Override
			public Admin doInHibernate(Session session) throws HibernateException {
				return session.load(Admin.class, id);
			}
		});
	}

}
