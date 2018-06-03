package service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import bean.GoingRecord;
import dao.GoingRecordDao;
import service.GoingRecordService;
@Transactional
public class GoingRecordServiceImpl implements GoingRecordService {
	private GoingRecordDao goingRecordDao;
	@Override
	public void save(GoingRecord GoingRecord) {
		goingRecordDao.save(GoingRecord);
	}

	@Override
	public void update(GoingRecord GoingRecord) {
		goingRecordDao.update(GoingRecord);
	}

	@Override
	public void delete(Long id) {
		goingRecordDao.delete(id);
	}

	@Override
	public List<GoingRecord> get(DetachedCriteria dc) {
		return goingRecordDao.get(dc);
	}

	@Override
	public List<GoingRecord> getAll() {
		return goingRecordDao.getAll();
	}

	public GoingRecordDao getGoingRecordDao() {
		return goingRecordDao;
	}

	public void setGoingRecordDao(GoingRecordDao goingRecordDao) {
		this.goingRecordDao = goingRecordDao;
	}

}
