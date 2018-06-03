package web.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import bean.Profession;
import service.CollegeService;
import service.ProfessionService;

public class ProfessionAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private Long profession_college;
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
	private ProfessionService professionService;
	private Map<String,Object> dataMap;
	private CollegeService collegeService;
	public String list() {
		setDataMap(new HashMap<>());
		List<Profession> all = professionService.getAll();
		List<HashMap<String, Object>> mapList = new ArrayList<>();
		for (Profession p : all) {
			HashMap<String, Object> map = new HashMap<>();
			map.put("id", p.getId());
			map.put("name", p.getName());
			map.put("college.id", p.getCollege().getId());
			map.put("college.name", p.getCollege().getName());
			mapList.add(map);
		}
		getDataMap().put("professions", mapList);
		getDataMap().put("status", "success");
		return "json";
	}
	public String getProfessionSelectItem() throws Exception {
		List<Profession> list = professionService.getAll();
		List<Map<String,Object>> professions = new ArrayList<>();
		for (Profession profession : list) {
			Map<String,Object> map = new HashMap<>();
			map.put("id", profession.getId());
			map.put("name", profession.getName());
			professions.add(map);
		}
		setDataMap(new HashMap<>());
		dataMap.put("status", "success");
		dataMap.put("professions", professions);
		return "json";
	}
	public String getCollegeSelectItem() {
		setDataMap(new HashMap<>());
		List<Map<String, Object>> collegeItemsForSelect = professionService.getCollegeItemsForSelect();
		dataMap.put("options", collegeItemsForSelect);
		return "json";
	}
	public String delete() {
		setDataMap(new HashMap<>());
		try {
			professionService.deleteById(id);
			getDataMap().put("status", "success");
		} catch (Exception e) {
			getDataMap().put("status", "failed");
			e.printStackTrace();
		}
		return "json";
	}
	public String add() {
		setDataMap(new HashMap<>());
		Profession profession = new Profession();
		profession.setId(id);
		profession.setName(name);
		profession.setCollege(collegeService.get(profession_college));
		try {
			if(getProfessionService().getByName(name)!=null) {
				getDataMap().put("status", "failed");
				getDataMap().put("msg", "专业名称不能重复");
			}else {
				getProfessionService().save(profession);
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
			Profession profession = getProfessionService().get(id);
			Profession byName = getProfessionService().getByName(name);
			if(byName!=null&&byName.getId()!=id) {
				getDataMap().put("status", "failed");
				getDataMap().put("msg", "专业名称不能重复");
			}else {
				profession.setName(name);
				profession.setCollege(collegeService.get(profession_college));
				getProfessionService().update(profession);
				getDataMap().put("status", "success");
			}
		} catch (Exception e) {
			getDataMap().put("status", "failed");
			e.printStackTrace();
		}
		return "json";
	}
	public Map<String,Object> getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map<String,Object> dataMap) {
		this.dataMap = dataMap;
	}
	public ProfessionService getProfessionService() {
		return professionService;
	}
	public void setProfessionService(ProfessionService professionService) {
		this.professionService = professionService;
	}
	public Long getProfession_college() {
		return profession_college;
	}
	public void setProfession_college(Long profession_college) {
		this.profession_college = profession_college;
	}
	public CollegeService getCollegeService() {
		return collegeService;
	}
	public void setCollegeService(CollegeService collegeService) {
		this.collegeService = collegeService;
	}
}
