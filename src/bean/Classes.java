package bean;

import java.util.Set;

//班级
public class Classes {
	private Long id;
	private String name;//班级名称
	//private College college;//班级所在学院
	private Profession profession;//班级所属专业 
	private Set<Student> students;//班级拥有学生
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
//	public College getCollege() {
//		return college;
//	}
//	public void setCollege(College college) {
//		this.college = college;
//	}
	public Profession getProfession() {
		return profession;
	}
	public void setProfession(Profession profession) {
		this.profession = profession;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
}
