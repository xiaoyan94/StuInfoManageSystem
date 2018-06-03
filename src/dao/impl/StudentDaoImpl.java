package dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.util.CollectionUtils;

import bean.Student;
import dao.StudentDao;

public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao {

	@Override
	public void add(Student stu) {
		getHibernateTemplate().saveOrUpdate(stu);
	}

	@Override
	public Student findByUsernameAndPasswd(final Student stu) {
		return getHibernateTemplate().execute(new HibernateCallback<Student>() {

			@Override
			public Student doInHibernate(Session session) throws HibernateException {
				String hql = "from Student where id=? and passwd=?";
				Query query = session.createQuery(hql);
				query.setParameter(0, stu.getId());
				query.setParameter(1, stu.getPasswd());
				Student student = (Student) query.uniqueResult();
				return student;
			}
		});
	}

	@Override
	public Student getStudent(DetachedCriteria dc) {
		List<?> list = getHibernateTemplate().findByCriteria(dc);
		if(CollectionUtils.isEmpty(list)) {
			return null;
		}else {
			return (Student) list.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getStudentList(DetachedCriteria dc) {
		return (List<Student>) getHibernateTemplate().findByCriteria(dc);
	}

	@Override
	public Serializable save(Student stu) {
		return getHibernateTemplate().save(stu);
	}

	@Override
	public void update(Student stu) {
		getHibernateTemplate().update(stu);
	}

	@Override
	public void delete(Student stu) {
		getHibernateTemplate().delete(stu);
	}

	@Override
	public List<?> getStudentsGroupByGoingName() {
		return getHibernateTemplate().execute(new HibernateCallback<List<?>>() {
			@Override
			public List<?> doInHibernate(Session session) throws HibernateException {
				String hql = "select g.name,count(*) from Student s,GoingRecord gr,Going g"+
						" where s.id=gr.student.id and g.id=gr.going.id"
						+ " group by g.name order by count(*) desc"
						;
				Query query = session.createQuery(hql);
				return query.list();
			}
		});
	}

	@Override
	public List<?> getStudentsGroupByGoingRecordAddress() {
		return getHibernateTemplate().execute(new HibernateCallback<List<?>>() {
			@Override
			public List<?> doInHibernate(Session session) throws HibernateException {
				String hql = "select gr.workAddress,count(*) from GoingRecord gr"
						+ " group by gr.workAddress order by count(*) desc";
				Query query = session.createQuery(hql);
				return query.list();
			}
		});
	}

}
