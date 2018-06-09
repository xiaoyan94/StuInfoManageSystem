package dao.impl.test;


import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import bean.Student;
import dao.StudentDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class StudentDaoTest extends AbstractJUnit4SpringContextTests {
	@Resource
	private StudentDao stuDao;
	@Test
	public void getCountTest() {
		//Long studentTotalCount = stuDao.getStudentTotalCount();
		//System.out.println(studentTotalCount);
		DetachedCriteria dc = DetachedCriteria.forClass(Student.class);
		dc.add(Restrictions.like("name", "韩梅梅%"));
		dc.add(Restrictions.like("sex", '女'));
		//Long studentCount = stuDao.getStudentCount(dc );
		//System.out.println(studentCount);
		dc.setProjection(null);
		List<Student> studentList = stuDao.getStudentList(dc, 0, 5);
		for (Student student : studentList) {
			System.out.println(student.getName());
			//System.out.println(student.getGoingRecord().getWorkAddress());
		}
	}
}
