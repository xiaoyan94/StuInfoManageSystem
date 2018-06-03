package dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import bean.Classes;

public interface ClassesDao {
	//增删改查
	void save(Classes classes);
	void delete(Classes classes);
	void update(Classes classes);
	List<Classes> get(DetachedCriteria dc);
}
