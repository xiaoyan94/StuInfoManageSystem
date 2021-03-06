package service.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import bean.Student;
import dao.StudentDao;
import service.StudentService;
import utils.Pager;

@Transactional
public class StudentServiceImpl implements StudentService {

	private StudentDao stuDao;
	public void setStuDao(StudentDao stuDao) {
		this.stuDao = stuDao;
	}
	@Override
	public void add(Student stu) {
		stuDao.add(stu);
	}
	@Override
	public Student findByUsernameAndPasswd(Student stu) {
		return stuDao.findByUsernameAndPasswd(stu);
	}
	@Override
	public void delete(Student stu) {
		stuDao.delete(stu);
	}
	@Override
	public void update(Student stu) {
		stuDao.update(stu);
	}
	@Override
	public List<Student> findAllStudents() {
		DetachedCriteria dc = DetachedCriteria.forClass(Student.class);
		return findStudentsByCriteria(dc);
	}
	
	@Override
	public List<Student> findStudentsByCriteria(DetachedCriteria dc) {
		return stuDao.getStudentList(dc);
	}
	@Override
	public Serializable save(Student stu) {
		return stuDao.save(stu);
	}
	/**
	 * TODO 自定义返回的字段
	 */
	@Override
	public String getAllStudentsToJson() {
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject ;
		List<Student> students = findAllStudents();
		for (Student stu : students) {
			jsonObject = new JSONObject();
			jsonObject.put("id", stu.getId());
			jsonObject.put("name", stu.getName());
			jsonObject.put("sex", stu.getSex());
			jsonObject.put("class", stu.getClasses().getName());
			jsonObject.put("going", stu.getGoingRecord().getGoing().getName());
			jsonArray.add(jsonObject);
		}
		String json = jsonArray.toJSONString();
		System.out.println(json);
		return json;
	}
	@Override
	public Student findById(Long id) {
		DetachedCriteria dc = DetachedCriteria.forClass(Student.class);
		dc.add(Restrictions.eq("id", id));
		return stuDao.getStudent(dc );
	}
	@Override
	public List<?> getStudentsCountGroupByGoingName() {
		return stuDao.getStudentsGroupByGoingName();
	}
	@Override
	public List<?> getStudentsCountGroupByGoingRecordAddress() {
		return stuDao.getStudentsGroupByGoingRecordAddress();
	}
	@Override
	public Pager<Student> findStudentsPagerByCriteria(DetachedCriteria dc, int currentPage, int pageSize) {
		//查询总记录数
		Long studentCount = stuDao.getStudentCount(dc);
		//根据总记录数、当前页、每页大小建立Pager对象
		Pager<Student> p = new Pager<>(studentCount,currentPage,pageSize);
		//根据pager对象的当前页和每页大小查询分页数据
		List<Student> dataList = stuDao.getStudentList(dc,p.getCurrentPage(),p.getPageSize());
		//将分页数据放进pager对象中
		p.setDataList(dataList );
		return p;
	}

}
