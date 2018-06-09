package dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import bean.Notice;
import dao.NoticeDao;

public class NoticeDaoImpl extends HibernateDaoSupport implements NoticeDao {

	@Override
	public Serializable save(Notice notice) {
		return getHibernateTemplate().save(notice);
	}

	@Override
	public boolean delete(Long id) {
		Notice notice = get(id);
		if(notice!=null) {
			try {
				getHibernateTemplate().delete(notice);
			} catch (DataAccessException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean update(Notice notice) {
		try {
			getHibernateTemplate().update(notice);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Notice get(final Long id) {
		return getHibernateTemplate().execute(new HibernateCallback<Notice>() {
			@Override
			public Notice doInHibernate(Session session) throws HibernateException {
				return session.load(Notice.class, id);
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Notice> getALl() {
		List<?> list = getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(Notice.class));
		return (List<Notice>) list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Notice> getPagerList(DetachedCriteria dc,int startIdx, int pageSize) {
		dc.addOrder(Order.desc("time"));
		//解决返回List<Object[]>而不是List<Notice>的问题
		//https://docs.jboss.org/hibernate/orm/3.5/reference/zh-CN/html/querycriteria.html#querycriteria-associations
		dc.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List<?> list = getHibernateTemplate().findByCriteria(dc,startIdx,pageSize);
		Iterator<?> iterator = list.iterator();
		List<Notice> noticeList = new ArrayList<>();
		while (iterator.hasNext()) {
			Map<String,Object> map = (Map<String, Object>) iterator.next();
			Notice notice = (Notice) map.get(Criteria.ROOT_ALIAS);
//			Admin admin = (Admin) map.get("a");
//			System.out.println(admin);
			//System.out.println(notice);
			noticeList.add(notice);
		}
		return (List<Notice>) noticeList;
	}

	@Override
	public Number getCount(DetachedCriteria dc) {
		dc.setProjection(Projections.rowCount());
		Number n = (Number) getHibernateTemplate().findByCriteria(dc).get(0);
		dc.setProjection(null);
		return n;
	}

}
