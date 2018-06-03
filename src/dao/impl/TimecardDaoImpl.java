package dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.util.CollectionUtils;

import bean.Student;
import bean.Timecard;
import dao.TimecardDao;

public class TimecardDaoImpl extends HibernateDaoSupport implements TimecardDao {

	@Override
	public void save(Timecard timecard) {
		getHibernateTemplate().save(timecard);
	}

	@Override
	public void delete(final Long id) {
		getHibernateTemplate().execute(new HibernateCallback<Boolean>() {
			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("DELETE FROM Timecard WHERE id=?");
				query.setLong(0, id);
				return query.executeUpdate()>0;
			}
		});
	}

	@Override
	public void update(Timecard timecard) {
		getHibernateTemplate().update(timecard);
	}

	@Override
	public Timecard get(Long id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Timecard.class);
		criteria.add(Restrictions.eq("id", id));
		List<Timecard> list = get(criteria);
		if(CollectionUtils.isEmpty(list)) {
			return null;
		}else {
			return list.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Timecard> get(DetachedCriteria dc) {
		return (List<Timecard>) getHibernateTemplate().findByCriteria(dc);
	}

	@Override
	public List<Timecard> getByStudent(Student stu) {
		return getHibernateTemplate().execute(new HibernateCallback<List<Timecard>>() {
			@SuppressWarnings("unchecked")
			@Override
			public List<Timecard> doInHibernate(Session session) throws HibernateException {
				String hql = "select t FROM Timecard t,Student s WHERE t.student.id=s.id AND s.id=:id order by t.time";
				Query query = session.createQuery(hql);
				query.setLong("id", stu.getId());
				return (List<Timecard>) query.list();
			}
		});
	}

	@Override
	public List<Timecard> getByDate(Date date) {
		return getHibernateTemplate().execute(new HibernateCallback<List<Timecard>>() {

			@SuppressWarnings("unchecked")
			@Override
			public List<Timecard> doInHibernate(Session session) throws HibernateException {
				String hql = "FROM Timecard t WHERE Date(t.time) = :date";
				Query query = session.createQuery(hql);
				query.setDate("date", date);
				return query.list();
			}
		});
	}

	@Override
	public List<?> getByStudentAndDate(Student stu, Date date) {
		return getHibernateTemplate().execute(new HibernateCallback<List<?>>() {
			@Override
			public List<?> doInHibernate(Session session) throws HibernateException {
				String hql = "SELECT t FROM Timecard t,Student s WHERE t.student.id=s.id AND s.id=:id AND Date(t.time) = :date";
				Query query = session.createQuery(hql);
				query.setLong("id", stu.getId());
				query.setDate("date", date);
				return (List<?>) query.list();
			}
		});
	}

	@Override
	public List<Student> getSignedStudentsByDate(Date date) {
		return getHibernateTemplate().execute(new HibernateCallback<List<Student>>() {
			@SuppressWarnings("unchecked")
			@Override
			public List<Student> doInHibernate(Session session) throws HibernateException {
				String hql = "SELECT s FROM Timecard t,Student s WHERE t.student.id=s.id AND Date(t.time) = :date";
				Query query = session.createQuery(hql);
				query.setDate("date", date);
				return (List<Student>) query.list();
			}
		});
	}

	@Override
	public List<Student> getUnsignedStudentsByDate(Date date) {
		return getHibernateTemplate().execute(new HibernateCallback<List<Student>>() {
			@SuppressWarnings("unchecked")
			@Override
			public List<Student> doInHibernate(Session session) throws HibernateException {
				
				Criteria criteria = session.createCriteria(Student.class);
				
				DetachedCriteria inCriteria = DetachedCriteria.forClass(Timecard.class);
				inCriteria.setProjection(Property.forName("student.id"));
				
				criteria.add(Property.forName("id").notIn(inCriteria));
				List<?> list = criteria.list();
				
				return (List<Student>) list;
			}
		});
	}


}
