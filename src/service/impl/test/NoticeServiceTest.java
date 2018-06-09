package service.impl.test;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import bean.Student;
import service.StudentService;
import utils.Pager;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Transactional
public class NoticeServiceTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Resource
	private StudentService stuService;
	@Test
	public void findStudentsPagerByCriteriaTest() {
		DetachedCriteria dc = DetachedCriteria.forClass(Student.class)
				.add(Restrictions.like("name", "%韩梅梅%"))
				.add(Restrictions.like("sex", '女'))
				.addOrder(Order.desc("id"))
				.createCriteria("goingRecord")
					.add(Restrictions.like("workAddress", "%"+"杭州"+"%"))
				.createCriteria("student")
				.createCriteria("classes")
					.add(Restrictions.like("name", "%测试%"))
				.createCriteria("profession")
					.add(Restrictions.like("name", "%化学%"))
				.createCriteria("college")
					.add(Restrictions.like("name", "%学院%"))
				;
		int currentPage = 0;
		int pageSize = 8;
		Pager<Student> pager = stuService.findStudentsPagerByCriteria(dc , currentPage, pageSize);
		List<Student> dataList = pager.getDataList();
		for (Student student : dataList) {
			System.out.println(student.getName());
		}
	}
}
