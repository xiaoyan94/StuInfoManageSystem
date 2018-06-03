package web.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;

import com.opensymphony.xwork2.ActionSupport;

import bean.Classes;
import bean.Profession;
import service.ClassesService;
import service.ProfessionService;

public class ClassesAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> dataMap = new HashMap<>();
	private ClassesService classesService;
	private ProfessionService professionService;
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
	public Long getClasses_profession() {
		return classes_profession;
	}
	public void setClasses_profession(Long classes_profession) {
		this.classes_profession = classes_profession;
	}
	private Long classes_profession;
	public String list() throws Exception {
		List<Classes> list = classesService.getList(DetachedCriteria.forClass(Classes.class));
		setDataMap(new HashMap<>());
		List<HashMap<String, Object>> mapList = new ArrayList<>();
		for (Classes c : list) {
			HashMap<String, Object> map = new HashMap<>();
			map.put("id", c.getId());
			map.put("name", c.getName());
			map.put("profession.name", c.getProfession().getName());
			map.put("profession.college.name", c.getProfession().getCollege().getName());
			mapList.add(map);
		}
		getDataMap().put("classes", mapList);
		dataMap.put("status", "success");
		return "json";
	}
	public String delete() {
		setDataMap(new HashMap<>());
		try {
			Classes classes = classesService.getById(id);
			classes.setProfession(null);
			classesService.delete(classes);
			getDataMap().put("status", "success");
		} catch (Exception e) {
			getDataMap().put("status", "failed");
			e.printStackTrace();
		}
		return "json";
	}
	public String add() {
		setDataMap(new HashMap<>());
		Classes classes = new Classes();
		classes.setId(id);
		classes.setName(name);
		classes.setProfession(professionService.get(classes_profession));
		try {
			if(getClassesService().getByName(name)!=null) {
				getDataMap().put("status", "failed");
				getDataMap().put("msg", "名称不能重复");
			}else {
				getClassesService().save(classes);
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
			Classes classes = getClassesService().getById(id);
			Classes byName = getClassesService().getByName(name);
			if(byName!=null&&byName.getId()!=id) {
				getDataMap().put("status", "failed");
				getDataMap().put("msg", "名称不能重复");
			}else {
				classes.setName(name);
				classes.setProfession(professionService.get(classes_profession));
				getClassesService().update(classes);
				getDataMap().put("status", "success");
			}
		} catch (Exception e) {
			getDataMap().put("status", "failed");
			e.printStackTrace();
		}
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
	public String getClassesSelectItem() throws Exception {
		List<Classes> list = classesService.getList(DetachedCriteria.forClass(Classes.class));
		List<Map<String,Object>> classess = new ArrayList<>();
		for (Classes Classes : list) {
			Map<String,Object> map = new HashMap<>();
			map.put("id", Classes.getId());
			map.put("name", Classes.getName());
			classess.add(map);
		}
		setDataMap(new HashMap<>());
		dataMap.put("status", "success");
		dataMap.put("classes", classess);
		return "json";
	}
	public ClassesService getClassesService() {
		return classesService;
	}
	public void setClassesService(ClassesService classesService) {
		this.classesService = classesService;
	}
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	public ProfessionService getProfessionService() {
		return professionService;
	}
	public void setProfessionService(ProfessionService professionService) {
		this.professionService = professionService;
	}
}
