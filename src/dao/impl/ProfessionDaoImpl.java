package dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import bean.Profession;
import dao.ProfessionDao;

public class ProfessionDaoImpl extends HibernateDaoSupport implements ProfessionDao {

	@Override
	public void save(Profession profession) {
		getHibernateTemplate().save(profession);
	}

	@Override
	public void update(Profession profession) {
		getHibernateTemplate().update(profession);
	}

	@Override
	public void delete(Profession profession) {
		getHibernateTemplate().delete(profession);
	}

	@Override
	public void deleteById(final Long id) {
		getHibernateTemplate().execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("DELETE FROM Profession WHERE id=?");
				query.setLong(0, id);
				;
				return query.executeUpdate() > 0;
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Profession> get(DetachedCriteria dc) {
		return (List<Profession>) getHibernateTemplate().findByCriteria(dc);
	}

}
