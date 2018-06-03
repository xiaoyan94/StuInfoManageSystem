package web.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.CollectionUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import bean.Classes;
import bean.Going;
import bean.GoingRecord;
import bean.Student;
import service.ClassesService;
import service.GoingRecordService;
import service.GoingService;
import service.StudentService;

public class StudentAction extends ActionSupport {
	private StudentService stuService;
	private ClassesService classesService;
	private GoingService goingService;
	private GoingRecordService goingRecordService;
	public GoingService getGoingService() {
		return goingService;
	}

	public void setGoingService(GoingService goingService) {
		this.goingService = goingService;
	}

	public GoingRecordService getGoingRecordService() {
		return goingRecordService;
	}

	public void setGoingRecordService(GoingRecordService goingRecordService) {
		this.goingRecordService = goingRecordService;
	}

	private Map<String, Object> dataMap = new HashMap<>();
	private Long id;
	private String name;
	private String password;
	private String idCard;
	private Character sex;
	private String tel;
	private Long stu_classes;
	private Long stu_going;
	
	private String workName;
	private String workLinkmanName;
	private String workTel;
	private String workAddress;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getStu_going() {
		return stu_going;
	}

	public void setStu_going(Long stu_going) {
		this.stu_going = stu_going;
	}

	public String getWorkName() {
		return workName;
	}

	public void setWorkName(String workName) {
		this.workName = workName;
	}

	public String getWorkLinkmanName() {
		return workLinkmanName;
	}

	public void setWorkLinkmanName(String workLinkmanName) {
		this.workLinkmanName = workLinkmanName;
	}

	public String getWorkTel() {
		return workTel;
	}

	public void setWorkTel(String workTel) {
		this.workTel = workTel;
	}

	public String getWorkAddress() {
		return workAddress;
	}

	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}

	private static final long serialVersionUID = 1L;
	public String add() {
		setDataMap(new HashMap<>());
		Student stu = new Student();
		stu.setId(id);
		Classes classes = classesService.getById(stu_classes);
		stu.setClasses(classes);
		
		GoingRecord goingRecord = new GoingRecord();
		DetachedCriteria dc = DetachedCriteria.forClass(Going.class);
		dc.add(Restrictions.eq("id",stu_going));
		List<Going> goingList = goingService.get(dc);
		if(!CollectionUtils.isEmpty(goingList)) {
			goingRecord.setGoing(goingList.get(0));
		}
		goingRecord.setWorkAddress(workAddress);
		goingRecord.setWorkLinkmanName(workLinkmanName);
		goingRecord.setWorkName(workName);
		goingRecord.setWorkTel(workTel);
		//goingRecordService.save(goingRecord);
		stu.setIdCard(idCard);
		stu.setName(name);
		stu.setPasswd(password);
		stu.setSex(sex);
		stu.setTel(tel);
		//此时的goingRecord还没有id，因为是save-update所以写这句报错
		stu.setGoingRecord(goingRecord);
		goingRecord.setStudent(stu);
		//stuService.save(stu);
		try {
			if(stuService.findById(id)!=null) {
				getDataMap().put("status", "failed");
				getDataMap().put("msg", "  学号不能重复");
			}else {
				stuService.add(stu);
				getDataMap().put("status", "success");
			}
		}catch (Exception e) {
			getDataMap().put("status", "failed");
			e.printStackTrace();
		}
		return "json";
	}
	public String delete() {
		setDataMap(new HashMap<>());
		try {
			Student student = stuService.findById(id);
			stuService.delete(student);
			getDataMap().put("status", "success");
		} catch (Exception e) {
			getDataMap().put("status", "failed");
			e.printStackTrace();
		}
		return "json";
	}
	public String getById() {
		Student student = stuService.findById(id);
		if(student!=null) {
			if(student.getClasses()!=null) {
				if(!CollectionUtils.isEmpty(student.getClasses().getStudents()))
					student.getClasses().getStudents().clear();
				
				if(student.getClasses().getProfession()!=null) {
					if(!CollectionUtils.isEmpty(student.getClasses().getProfession().getClasses()))
						student.getClasses().getProfession().getClasses().clear();
					if(student.getClasses().getProfession().getCollege()!=null) {
						if(!CollectionUtils.isEmpty(student.getClasses().getProfession().getCollege().getProfessions()))
							student.getClasses().getProfession().getCollege().getProfessions().clear();
					}
				}
			}
			if(student.getGoingRecord()!=null) {
				if(student.getGoingRecord().getGoing()!=null) {
					if(!CollectionUtils.isEmpty(student.getGoingRecord().getGoing().getGoingRecords())) {
						student.getGoingRecord().getGoing().getGoingRecords().clear();
					}
				}
			}
			//student.setClasses(null);
			dataMap.put("status", "success");
			dataMap.put("student", student);
		}else {
			dataMap.put("status", "failed");
		}
		return "json";
	}
	public String update() {
		setDataMap(new HashMap<>());
		try {
			Student stu = stuService.findById(id);
			stu.setClasses(classesService.getById(stu_classes));
			GoingRecord goingRecord = stu.getGoingRecord();
			DetachedCriteria dc = DetachedCriteria.forClass(Going.class);
			dc.add(Restrictions.eq("id", stu_going));
			List<Going> list = goingService.get(dc);
			if(goingRecord==null) {
				goingRecord = new GoingRecord();
			}
			goingRecord.setGoing(list.get(0));
			goingRecord.setWorkAddress(workAddress);
			goingRecord.setWorkLinkmanName(workLinkmanName);
			goingRecord.setWorkName(workName);
			goingRecord.setWorkTel(workTel);
			stu.setIdCard(idCard);
			stu.setName(name);
			stu.setPasswd(password);
			stu.setSex(sex);
			stu.setTel(tel);
			goingRecord.setStudent(stu);
			stu.setGoingRecord(goingRecord);
			getStuService().update(stu);
			getDataMap().put("status", "success");
		} catch (Exception e) {
			getDataMap().put("status", "failed");
			e.printStackTrace();
		}
		return "json";
	}
	public String list() throws Exception {
		List<Student> students = stuService.findAllStudents();
		for (Student student : students) {
			if(student.getClasses()!=null) {
				if(!CollectionUtils.isEmpty(student.getClasses().getStudents()))
					student.getClasses().getStudents().clear();
				
				if(student.getClasses().getProfession()!=null) {
					if(!CollectionUtils.isEmpty(student.getClasses().getProfession().getClasses()))
						student.getClasses().getProfession().getClasses().clear();
					if(student.getClasses().getProfession().getCollege()!=null) {
						if(!CollectionUtils.isEmpty(student.getClasses().getProfession().getCollege().getProfessions()))
							student.getClasses().getProfession().getCollege().getProfessions().clear();
					}
				}
			}
			if(student.getGoingRecord()!=null) {
				if(student.getGoingRecord().getGoing()!=null) {
					if(!CollectionUtils.isEmpty(student.getGoingRecord().getGoing().getGoingRecords())) {
						student.getGoingRecord().getGoing().getGoingRecords().clear();
					}
				}
			}
			student.setClasses(null);
		}
		dataMap.put("students", students);
		return "json";
	}
	public String login() throws Exception {
		Student stu = new Student();
		stu.setId(Long.valueOf(id));
		stu.setPasswd(password);
		Student existStu = stuService.findByUsernameAndPasswd(stu);
		if(existStu == null) {
			this.addActionError("用户名或密码错误！");
			return "toLogin";
		}else {
			ActionContext.getContext().getSession().put("user", existStu);
			return "toHome";
		}
	}
	

//	@Override
//	public String execute() throws Exception {
//		Student stu = new Student();
//		stu.setIdCard("34122618923434");
//		stu.setName("Name222");
//		stu.setSex('男');
//		stu.setTel("111111111111");
//		Classes classes = new Classes();
//		classes.setName("XXXXXXXXXXXX2班");
//		College college = new College();
//		college.setName("XXX学院");
//		Profession profession = new Profession();
//		profession.setName("XX专业");
//		profession.setCollege(college);
//		classes.setCollege(college);
//		classes.setProfession(profession);
//		stu.setClasses(classes);
//		stuService.add(stu);
//		return SUCCESS;
//	}
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public Character getSex() {
		return sex;
	}
	public void setSex(Character sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Long getStu_classes() {
		return stu_classes;
	}
	public void setStu_classes(Long stu_classes) {
		this.stu_classes = stu_classes;
	}
	public Long getStu_goingRecord() {
		return stu_going;
	}
	public void setStu_goingRecord(Long stu_goingRecord) {
		this.stu_going = stu_goingRecord;
	}
	public StudentService getStuService() {
		return stuService;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setStuService(StudentService stuService) {
		this.stuService = stuService;
	}

	public ClassesService getClassesService() {
		return classesService;
	}

	public void setClassesService(ClassesService classesService) {
		this.classesService = classesService;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
