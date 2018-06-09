package service.impl.test;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import bean.Notice;
import service.NoticeService;
import utils.Pager;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Transactional
public class StudentServiceTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Resource
	private NoticeService noticeService;
	@Test
	public void getPager() {
		for(int i=0;i<20;i++) {
			Notice notice = new Notice( "标题", "内容", new Timestamp(System.currentTimeMillis()), null);
			Serializable save = noticeService.save(notice);
			System.out.println(save);
		}
		DetachedCriteria dc = DetachedCriteria.forClass(Notice.class);
		int currentPage = 5;
		int pageSize = 4;
		Pager<Notice> pager = noticeService.getPager(dc , currentPage, pageSize);
		List<Notice> dataList = pager.getDataList();
		for (Notice n : dataList) {
			System.out.println(n);
		}
	}
}
