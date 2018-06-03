package dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import bean.Going;
import dao.GoingDao;

public class GoingDaoImpl extends HibernateDaoSupport implements GoingDao {

	@Override
	public void save(Going going) {
		getHibernateTemplate().save(going);
	}

	@Override
	public void update(Going going) {
		getHibernateTemplate().update(going);
	}

	@Override
	public void delete(final Long id) {
		getHibernateTemplate().execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("DELETE FROM Going WHERE id=?");
				query.setLong(0, id);
				int i = query.executeUpdate();
				return i > 0;
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Going> get(DetachedCriteria dc) {
		return (List<Going>) getHibernateTemplate().findByCriteria(dc);
	}

	@Override
	public List<Going> getAll() {
		return get(DetachedCriteria.forClass(Going.class));
	}

}
