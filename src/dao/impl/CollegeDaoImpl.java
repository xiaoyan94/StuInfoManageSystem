package dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import bean.College;
import dao.CollegeDao;

public class CollegeDaoImpl extends HibernateDaoSupport implements CollegeDao {

	@Override
	public void save(College college) {
		getHibernateTemplate().save(college);
	}

	@Override
	public void delete(College college) {
		getHibernateTemplate().delete(college);
	}

	@Override
	public void update(College college) {
		getHibernateTemplate().update(college);
	}

	@Override
	public College get(final Long id) {
		return getHibernateTemplate().execute(new HibernateCallback<College>() {

			@Override
			public College doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("FROM College WHERE id=?");
				query.setParameter(0, id);
				return (College) query.uniqueResult();
			}
		});
	}

	@Override
	public List<College> getAll() {
		DetachedCriteria dc = DetachedCriteria.forClass(College.class);
		@SuppressWarnings("unchecked")
		List<College> list = (List<College>) getHibernateTemplate().findByCriteria(dc);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<College> get(DetachedCriteria dc) {
		return (List<College>) getHibernateTemplate().findByCriteria(dc);
	}

}
