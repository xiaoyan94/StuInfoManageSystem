package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import bean.Notice;

public interface NoticeDao {
	Serializable save(Notice notice);
	boolean delete(Long id);
	boolean update(Notice notice);
	Notice get(Long id);
	List<Notice> getALl();
	Number getCount(DetachedCriteria dc);
	List<Notice> getPagerList(DetachedCriteria dc,int startIdx,int pageSize);
}
