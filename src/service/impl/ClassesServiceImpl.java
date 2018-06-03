package service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import bean.Classes;
import dao.ClassesDao;
import service.ClassesService;
@Transactional
public class ClassesServiceImpl implements ClassesService {

	private ClassesDao classesDao;
	
	@Override
	public void save(Classes classes) {
		classesDao.save(classes);
	}

	@Override
	public void delete(Classes classes) {
		classesDao.delete(classes);
	}

	@Override
	public void update(Classes classes) {
		classesDao.update(classes);
	}

	@Override
	public List<Classes> getList(DetachedCriteria dc) {
		return classesDao.get(dc);
	}

	@Override
	public Classes get(DetachedCriteria dc) {
		List<Classes> list = getList(dc);
		if(CollectionUtils.isEmpty(list)) {
			return null;
		}else {
			return list.get(0);
		}
	}

	@Override
	public Classes getById(Long id) {
		DetachedCriteria dc = DetachedCriteria.forClass(Classes.class);
		dc.add(Restrictions.eq("id",id));
		return get(dc);
	}

	@Override
	public Classes getByName(String name) {
		DetachedCriteria dc = DetachedCriteria.forClass(Classes.class);
		dc.add(Restrictions.eq("name",name));
		return get(dc);
	}

	public ClassesDao getClassesDao() {
		return classesDao;
	}

	public void setClassesDao(ClassesDao classesDao) {
		this.classesDao = classesDao;
	}

}
