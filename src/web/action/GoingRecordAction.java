package web.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionSupport;

import bean.GoingRecord;
import service.GoingRecordService;

public class GoingRecordAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private GoingRecordService GoingRecordService;
	private Map<String,Object> dataMap;
	private String name;
	private String workAddress;
	public String getGoingRecordsByAddress(){
		setDataMap(new HashMap<>());
		List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
		DetachedCriteria dc = DetachedCriteria.forClass(GoingRecord.class);
		dc.add(Restrictions.eq("workAddress", getWorkAddress()));
		List<GoingRecord> list = GoingRecordService.get(dc);
		for (GoingRecord record : list) {
			Map<String,Object> map = new HashMap<>();
			map.put("student.id", record.getStudent().getId());
			map.put("student.name", record.getStudent().getName());
			map.put("student.sex", record.getStudent().getSex());
			map.put("student.tel", record.getStudent().getTel());
			map.put("student.classes", record.getStudent().getClasses().getName());
			map.put("student.profession", record.getStudent().getClasses().getProfession().getName());
			map.put("student.college", record.getStudent().getClasses().getProfession().getCollege().getName());
			map.put("going", record.getGoing().getName());
			map.put("workName", record.getWorkName());
			map.put("workAddress", record.getWorkAddress());
			map.put("workLinkmanName", record.getWorkLinkmanName());
			map.put("workTel", record.getWorkTel());
			mapList.add(map);
		}
		dataMap.put("status", SUCCESS);
		dataMap.put("data", mapList);
		return "json";
	}
	public GoingRecordService getGoingRecordService() {
		return GoingRecordService;
	}
	public void setGoingRecordService(GoingRecordService GoingRecordService) {
		this.GoingRecordService = GoingRecordService;
	}
	public Map<String,Object> getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map<String,Object> dataMap) {
		this.dataMap = dataMap;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWorkAddress() {
		return workAddress;
	}
	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}
}
