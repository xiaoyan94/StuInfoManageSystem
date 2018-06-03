package web.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import bean.College;
import service.CollegeService;

public class CollegeAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
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
	private CollegeService collegeService;
	private Map<String,Object> dataMap;
	public String list() {
		setDataMap(new HashMap<>());
		List<College> all = collegeService.getAll();
		List<HashMap<String, Object>> mapList = new ArrayList<>();
		for (College college : all) {
			HashMap<String, Object> map = new HashMap<>();
			map.put("id", college.getId());
			map.put("name", college.getName());
			mapList.add(map);
		}
		getDataMap().put("colleges", mapList);
		getDataMap().put("status", "success");
		return "list";
	}
	public String delete() {
		setDataMap(new HashMap<>());
		try {
			collegeService.delete(collegeService.get(id));
			getDataMap().put("status", "success");
		} catch (Exception e) {
			getDataMap().put("status", "failed");
			e.printStackTrace();
		}
		return "list";
	}
	public String add() {
		setDataMap(new HashMap<>());
		College college = new College();
		college.setName(name);
		try {
			if(collegeService.getByName(name)!=null) {
				getDataMap().put("status", "failed");
				getDataMap().put("msg", "学院名称不能重复");
			}else {
				collegeService.save(college);
				getDataMap().put("status", "success");
			}
		} catch (Exception e) {
			getDataMap().put("status", "failed");
			e.printStackTrace();
		}
		return "list";
	}
	public String update() {
		setDataMap(new HashMap<>());
		try {
			if(collegeService.getByName(name)!=null) {
				getDataMap().put("status", "failed");
				getDataMap().put("msg", "学院名称不能重复");
			}else {
				College college = collegeService.get(id);
				college.setName(name);
				collegeService.update(college);
				getDataMap().put("status", "success");
			}
		} catch (Exception e) {
			getDataMap().put("status", "failed");
			e.printStackTrace();
		}
		return "list";
	}
	public CollegeService getCollegeService() {
		return collegeService;
	}
	public void setCollegeService(CollegeService collegeService) {
		this.collegeService = collegeService;
	}
	public Map<String,Object> getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map<String,Object> dataMap) {
		this.dataMap = dataMap;
	}
}
