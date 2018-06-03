package service;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;

import bean.Profession;

public interface ProfessionService {
	void save(Profession profession);
	void update(Profession profession);
	void delete(Profession profession);
	void deleteById(Long id);
	List<Profession> get(DetachedCriteria dc);
	List<Profession> getAll();
	Profession get(Long id);
	Profession getByName(String name);
	List<Map<String,Object>> getCollegeItemsForSelect();
}
