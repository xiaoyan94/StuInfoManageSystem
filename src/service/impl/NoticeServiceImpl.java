package service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bean.Admin;
import bean.Notice;
import dao.AdminDao;
import dao.NoticeDao;
import service.NoticeService;
import utils.Pager;
@Transactional
@Service
public class NoticeServiceImpl implements NoticeService {
	@Resource
	private NoticeDao noticeDao;
	@Resource
	private AdminDao adminDao;
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public Serializable save(Notice notice) {
		Long adminId = notice.getAdmin().getAdminId();
//		DetachedCriteria dc = DetachedCriteria.forClass(Admin.class).add(Restrictions.eq("adminId", adminId));
//		Admin admin = adminDao.getAdmin(dc);
		//使用load整个保存过程只执行一条insert语句
		Admin admin = adminDao.load(adminId);
		notice.setAdmin(admin);
		return noticeDao.save(notice);
	}

	@Override
	public boolean delete(Long id) {
		return noticeDao.delete(id);
	}

	@Override
	public boolean update(Notice notice) {
		return noticeDao.update(notice);
	}

	@Override
	public Notice get(Long id) {
		return noticeDao.get(id);
	}

	@Override
	public List<Notice> getALl() {
		return noticeDao.getALl();
	}

	@Override
	public Number getCount(DetachedCriteria dc) {
		return noticeDao.getCount(dc);
	}

	@Override
	public Pager<Notice> getPager(DetachedCriteria dc, int currentPage, int pageSize) {
		long totalCount = getCount(dc).longValue();
		Pager<Notice> pager = new Pager<>(totalCount, currentPage, pageSize);
		int startIdx = (currentPage - 1) * pageSize;
		List<Notice> dataList = noticeDao.getPagerList(dc, startIdx , pageSize);
		pager.setDataList(dataList);
		return pager;
	}

	public NoticeDao getNoticeDao() {
		return noticeDao;
	}

	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

}
