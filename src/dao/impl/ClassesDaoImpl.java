package dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import bean.Classes;
import dao.ClassesDao;

public class ClassesDaoImpl extends HibernateDaoSupport implements ClassesDao {

	@Override
	public void save(Classes classes) {
		getHibernateTemplate().save(classes);
	}

	@Override
	public void delete(Classes classes) {
		getHibernateTemplate().delete(classes);
	}

	@Override
	public void update(Classes classes) {
		getHibernateTemplate().update(classes);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Classes> get(DetachedCriteria dc) {
		return (List<Classes>) getHibernateTemplate().findByCriteria(dc);
	}

}
