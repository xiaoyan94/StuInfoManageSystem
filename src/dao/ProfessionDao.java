package dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import bean.Profession;

public interface ProfessionDao {
	void save(Profession profession);
	void update(Profession profession);
	void delete(Profession profession);
	void deleteById(Long id);
	List<Profession> get(DetachedCriteria dc);
}
