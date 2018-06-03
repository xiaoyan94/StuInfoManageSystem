package dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import bean.College;

public interface CollegeDao {
	void save(College college);
	void delete(College college);
	void update(College college);
	College get(Long id);
	List<College> get(DetachedCriteria dc);
	List<College> getAll();
}
