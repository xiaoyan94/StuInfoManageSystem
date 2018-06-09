package web.action;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import bean.Notice;
import service.NoticeService;
import utils.MyStringUtil;
import utils.Pager;
import utils.PagerUtil;
@Controller()
@Scope("prototype")
public class NoticeAction extends ActionSupport implements ModelDriven<Notice>{
	private static final long serialVersionUID = -6081936088581585987L;
	private static final String JSON = "json";
	private static final String STATUS = "status";
	@Resource
	private NoticeService noticeService;
	
	private Map<String, Object> dataMap = new HashMap<String, Object>();

	private Notice notice = new Notice();
	
	private String searchKey;
	private int currentPage;
	private int pageSize;
	
	private void sleep(long l) {
		try {
			Thread.sleep(l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//-----------------------------------------
	public String save() {
		sleep(500);
		notice.setTime(new Timestamp(System.currentTimeMillis()));
		Serializable save = noticeService.save(notice);
		dataMap.put(STATUS, true);
		dataMap.put(SUCCESS, true);
		dataMap.put("id", save);
		return JSON;
	}
	public String update() {
		//Notice notice2 = noticeService.get(notice.getId());
		
		return JSON;
	}
	public String delete() {
		dataMap.put(STATUS, true);
		boolean delete = noticeService.delete(notice.getId());
		if(delete) {
			dataMap.put(SUCCESS, true);
		}else {
			dataMap.put(SUCCESS, false);
		}
		return JSON;
	}
	public String list() {
		sleep(500);
		DetachedCriteria dc = DetachedCriteria.forClass(Notice.class);
		if(MyStringUtil.isNotEmpty(searchKey)) {
			//Hibernate中两个条件的or运算写法
//			dc.add(Restrictions.or(
//					Restrictions.like("title", "%"+searchKey+"%"),
//					Restrictions.like("content", "%"+searchKey+"%") ) );
			//Hibernate中三个条件的or运算写法:disjunction是数学中析取的意思就是逻辑或
			Disjunction disjunction = Restrictions.disjunction();
			disjunction.add(Restrictions.like("a.adminName", "%"+searchKey+"%"));
			disjunction.add(Restrictions.like("a.adminRealName", "%"+searchKey+"%"));
			disjunction.add(Restrictions.like("a.adminEmail", "%"+searchKey+"%"));
			disjunction.add(Restrictions.like("a.adminTel", "%"+searchKey+"%"));
			disjunction.add(Restrictions.like("title", "%"+searchKey+"%"));
			disjunction.add(Restrictions.like("content", "%"+searchKey+"%"));
			//关于关联查询看文档https://docs.jboss.org/hibernate/orm/3.5/reference/zh-CN/html/querycriteria.html#querycriteria-associations
			dc.createAlias("admin", "a").add(disjunction);
		}
	
		Pager<Notice> pager = noticeService.getPager(dc , currentPage, pageSize);
		List<Notice> dataList = pager.getDataList();
		PagerUtil.setPagerToDataMap(dataMap, pager, "notice", dataList);
		dataMap.put(SUCCESS, true);
		dataMap.put(STATUS, true);
		return JSON;
	}
	//-----------------------------------------
	
	public NoticeService getNoticeService() {
		return noticeService;
	}

	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	@Override
	public Notice getModel() {
		return notice;
	}
}
