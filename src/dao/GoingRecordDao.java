package dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import bean.GoingRecord;

public interface GoingRecordDao {
	void save(GoingRecord GoingRecord );
	void update(GoingRecord GoingRecord );
	void delete(Long id);
	List<GoingRecord> get(DetachedCriteria dc);
	List<GoingRecord> getAll();
}
