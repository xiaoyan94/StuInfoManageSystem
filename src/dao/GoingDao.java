package dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import bean.Going;

public interface GoingDao {
	void save(Going going );
	void update(Going going );
	void delete(Long id);
	List<Going> get(DetachedCriteria dc);
	List<Going> getAll();
}
