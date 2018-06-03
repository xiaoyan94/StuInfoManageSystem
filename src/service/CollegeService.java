package service;

import java.util.List;

import bean.College;

public interface CollegeService {
	void save(College college);
	void delete(College college);
	void update(College college);
	College get(Long id);
	College getByName(String name);
	List<College> getAll();
}
