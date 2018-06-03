package service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import bean.College;
import bean.Profession;
import dao.CollegeDao;
import dao.ProfessionDao;
import service.ProfessionService;

@Transactional
public class ProfessionServiceImpl implements ProfessionService{
	private ProfessionDao professionDao;
	private CollegeDao collegeDao;
	@Override
	public void save(Profession profession) {
		professionDao.save(profession);
	}

	@Override
	public void update(Profession profession) {
		professionDao.update(profession);
	}

	@Override
	public void delete(Profession profession) {
		professionDao.delete(profession);
	}

	@Override
	public void deleteById(Long id) {
		professionDao.deleteById(id);
	}

	@Override
	public List<Profession> get(DetachedCriteria dc) {
		return professionDao.get(dc);
	}

	@Override
	public List<Profession> getAll() {
		return get(DetachedCriteria.forClass(Profession.class));
	}

	@Override
	public Profession getByName(String name) {
		DetachedCriteria dc = DetachedCriteria.forClass(Profession.class);
		dc.add(Restrictions.eq("name", name));
		List<Profession> list = get(dc);
		if(CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}

	public ProfessionDao getProfessionDao() {
		return professionDao;
	}

	public void setProfessionDao(ProfessionDao professionDao) {
		this.professionDao = professionDao;
	}

	public CollegeDao getCollegeDao() {
		return collegeDao;
	}

	public void setCollegeDao(CollegeDao collegeDao) {
		this.collegeDao = collegeDao;
	}

	@Override
	public List<Map<String, Object>> getCollegeItemsForSelect() {
		List<College> list = collegeDao.getAll();
		List<Map<String, Object>> result = new ArrayList<>();
		for (College college : list) {
			Map<String, Object> map = new HashMap<>();
			map.put("id", college.getId());
			map.put("name", college.getName());
			result.add(map);
		}
		return result;
	}

	@Override
	public Profession get(Long id) {
		DetachedCriteria dc = DetachedCriteria.forClass(Profession.class);
		dc.add(Restrictions.eq("id", id));
		List<Profession> list = get(dc);
		if(CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}
	
}
