package dao.impl.test;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import bean.Notice;
import dao.NoticeDao;
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class NoticeDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Resource
	private NoticeDao noticeDao;
	@Test
	public void saveTest() {
		Notice notice = new Notice( "标题", "内容", new Timestamp(System.currentTimeMillis()), null);
		Serializable save = noticeDao.save(notice);
		System.out.println(save);
		Notice notice2 = noticeDao.get((Long) save);
		System.out.println(notice2);
		System.out.println(noticeDao.getALl());
		System.out.println(noticeDao.getCount(DetachedCriteria.forClass(Notice.class)));
		System.out.println(noticeDao.getALl().size());
		System.out.println(noticeDao.getPagerList(DetachedCriteria.forClass(Notice.class),0,1));
		boolean delete = noticeDao.delete((Long) save);
		System.out.println(delete);
	}
//	@Test
//	public void getCountTest() {
//		//Long studentTotalCount = stuDao.getStudentTotalCount();
//		//System.out.println(studentTotalCount);
//		DetachedCriteria dc = DetachedCriteria.forClass(Student.class);
//		dc.add(Restrictions.like("name", "韩梅梅%"));
//		dc.add(Restrictions.like("sex", '女'));
//		//Long studentCount = stuDao.getStudentCount(dc );
//		//System.out.println(studentCount);
//		dc.setProjection(null);
//		List<Student> studentList = noticeDao.getStudentList(dc, 0, 5);
//		for (Student student : studentList) {
//			System.out.println(student.getName());
//			//System.out.println(student.getGoingRecord().getWorkAddress());
//		}
//	}
}
