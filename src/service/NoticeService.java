package service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import bean.Notice;
import utils.Pager;

public interface NoticeService {
	Serializable save(Notice notice);
	boolean delete(Long id);
	boolean update(Notice notice);
	Notice get(Long id);
	List<Notice> getALl();
	Number getCount(DetachedCriteria dc);
	Pager<Notice> getPager(DetachedCriteria dc,int currentPage,int pageSize);
}
