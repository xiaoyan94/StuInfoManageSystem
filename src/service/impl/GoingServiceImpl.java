package service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import bean.Going;
import dao.GoingDao;
import service.GoingService;
@Transactional
public class GoingServiceImpl implements GoingService {
	private GoingDao goingDao;
	@Override
	public void save(Going going) {
		goingDao.save(going);
	}

	@Override
	public void update(Going going) {
		goingDao.update(going);
	}

	@Override
	public void delete(Long id) {
		goingDao.delete(id);
	}

	@Override
	public List<Going> get(DetachedCriteria dc) {
		return goingDao.get(dc);
	}

	@Override
	public List<Going> getAll() {
		return goingDao.getAll();
	}

	public GoingDao getGoingDao() {
		return goingDao;
	}

	public void setGoingDao(GoingDao goingDao) {
		this.goingDao = goingDao;
	}

}
