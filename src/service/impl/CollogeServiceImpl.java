package service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import bean.College;
import dao.CollegeDao;
import service.CollegeService;

@Transactional
public class CollogeServiceImpl implements CollegeService {
	private CollegeDao collegeDao;
	
	@Override
	public void save(College college) {
		collegeDao.save(college);
	}

	@Override
	public void delete(College college) {
		collegeDao.delete(college);
	}

	@Override
	public void update(College college) {
		collegeDao.update(college);
	}

	@Override
	public College get(Long id) {
		return collegeDao.get(id);
	}

	@Override
	public List<College> getAll() {
		return collegeDao.getAll();
	}

	public CollegeDao getCollegeDao() {
		return collegeDao;
	}

	public void setCollegeDao(CollegeDao collegeDao) {
		this.collegeDao = collegeDao;
	}

	@Override
	public College getByName(String name) {
		DetachedCriteria dc = DetachedCriteria.forClass(College.class);
		dc.add(Restrictions.eq("name",name));
		List<College> list = getCollegeDao().get(dc);
		if(CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}

}
