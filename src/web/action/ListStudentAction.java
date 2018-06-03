package web.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.CollectionUtils;

import com.opensymphony.xwork2.ActionSupport;

import bean.Student;
import service.StudentService;

public class ListStudentAction extends ActionSupport {
	private StudentService stuService;
	private Map<String, Object> dataMap = new HashMap<>();

	private static final long serialVersionUID = 1L;
	@Override
	public String execute() throws Exception {
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
			student.setClasses(null);
		}
		dataMap.put("students", students);
		return "json";
	}
	public StudentService getStuService() {
		return stuService;
	}
	public void setStuService(StudentService stuService) {
		this.stuService = stuService;
	}
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

}
