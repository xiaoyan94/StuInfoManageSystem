package web.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.CollectionUtils;

import com.opensymphony.xwork2.ActionSupport;

import bean.Going;
import bean.GoingRecord;
import service.GoingService;

public class GoingAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private GoingService goingService;
	private Map<String,Object> dataMap;
	
	private Long id;
	private String name;
	private String workAddress;
	
	public String getGoingRecordsByGoingName(){
		setDataMap(new HashMap<>());
		List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
		DetachedCriteria dc = DetachedCriteria.forClass(Going.class);
		dc.add(Restrictions.eq("name", name));
		List<Going> list = goingService.get(dc);
		Going going = null;
		if(list!=null) {
			going = list.get(0);
		}
		Set<GoingRecord> goingRecords = going.getGoingRecords();
		Iterator<GoingRecord> iterator = goingRecords.iterator();
		while(iterator.hasNext()) {
			GoingRecord record = iterator.next();
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
//		for (Going going : list) {
//			map.put("student.id", goingRecord.getStudent().getId());
//			map.put("student.name", goingRecord.getStudent().getName());
//			map.put("workAddress", goingRecord.getGoing().getName());
//		}
		dataMap.put("status", SUCCESS);
		dataMap.put("data", mapList);
		return "json";
	}
	
	
	
	public String list() {
		setDataMap(new HashMap<>());
		List<Going> all = goingService.getAll();
		List<HashMap<String, Object>> mapList = new ArrayList<>();
		for (Going p : all) {
			HashMap<String, Object> map = new HashMap<>();
			map.put("id", p.getId());
			map.put("name", p.getName());
			mapList.add(map);
		}
		getDataMap().put("goings", mapList);
		getDataMap().put("status", "success");
		return "json";
	}
	public String delete() {
		setDataMap(new HashMap<>());
		try {
			goingService.delete(getId());;
			getDataMap().put("status", "success");
		} catch (Exception e) {
			getDataMap().put("status", "failed");
			e.printStackTrace();
		}
		return "json";
	}
	public String add() {
		setDataMap(new HashMap<>());
		Going Going = new Going();
		Going.setName(getName());
		try {
			DetachedCriteria dc =  DetachedCriteria.forClass(Going.class);
			dc.add(Restrictions.eq("name", name));
			List<bean.Going> list = goingService.get(dc);
			if(!CollectionUtils.isEmpty(list)) {
				getDataMap().put("status", "failed");
				getDataMap().put("msg", "名称不能重复");
			}else {
				goingService.save(Going);
				getDataMap().put("status", "success");
			}
		} catch (Exception e) {
			getDataMap().put("status", "failed");
			e.printStackTrace();
		}
		return "json";
	}
	public String update() {
		setDataMap(new HashMap<>());
		try {
			DetachedCriteria dc =  DetachedCriteria.forClass(Going.class);
			dc.add(Restrictions.eq("name", name));
			List<Going> list = goingService.get(dc);
			if(!CollectionUtils.isEmpty(list)) {
				getDataMap().put("status", "failed");
				getDataMap().put("msg", "名称不能重复");
			}else {
				DetachedCriteria dc2 =  DetachedCriteria.forClass(Going.class);
				dc2.add(Restrictions.eq("id", id));
				Going going = goingService.get(dc2).get(0);
				going.setName(getName());
				goingService.update(going);
				getDataMap().put("status", "success");
			}
		} catch (Exception e) {
			getDataMap().put("status", "failed");
			e.printStackTrace();
		}
		return "json";
	}
	
	public String getGoingsSelectItem() throws Exception {
		List<Going> list = goingService.getAll();
		List<Map<String,Object>> goings = new ArrayList<>();
		for (Going Going : list) {
			Map<String,Object> map = new HashMap<>();
			map.put("id", Going.getId());
			map.put("name", Going.getName());
			goings.add(map);
		}
		setDataMap(new HashMap<>());
		dataMap.put("status", "success");
		dataMap.put("goings", goings);
		return "json";
	}
	
	public GoingService getgoingService() {
		return goingService;
	}
	public void setgoingService(GoingService goingService) {
		this.goingService = goingService;
	}
	public Map<String,Object> getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map<String,Object> dataMap) {
		this.dataMap = dataMap;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
