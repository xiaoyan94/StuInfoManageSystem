package service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import bean.Classes;

public interface ClassesService {
	void save(Classes classes);
	void delete(Classes classes);
	void update(Classes classes);
	List<Classes> getList(DetachedCriteria dc);
	Classes get(DetachedCriteria dc);
	Classes getById(Long id);
	Classes getByName(String name);
}