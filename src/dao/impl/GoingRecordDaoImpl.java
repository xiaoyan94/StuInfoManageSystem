package dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import bean.GoingRecord;
import dao.GoingRecordDao;

public class GoingRecordDaoImpl extends HibernateDaoSupport implements GoingRecordDao {

	@Override
	public void save(GoingRecord GoingRecord) {
		getHibernateTemplate().save(GoingRecord);
	}

	@Override
	public void update(GoingRecord GoingRecord) {
		getHibernateTemplate().update(GoingRecord);
	}

	@Override
	public void delete(Long id) {
		getHibernateTemplate().execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("DELETE FROM GoingRecord WHERE id=?");
				query.setLong(0, id);
				int i = query.executeUpdate();
				return i > 0;
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GoingRecord> get(DetachedCriteria dc) {
		return (List<GoingRecord>) getHibernateTemplate().findByCriteria(dc);
	}

	@Override
	public List<GoingRecord> getAll() {
		return get(DetachedCriteria.forClass(GoingRecord.class));
	}

}
