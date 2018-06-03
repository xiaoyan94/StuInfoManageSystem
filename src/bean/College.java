package bean;

import java.util.Set;

public class College {
	private Long id;//学院编号
	private String name;//学院名称
	//private Set<Classes> classes;//学院下属班级
	private Set<Profession> professions;//学院拥有专业
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
//	public Set<Classes> getClasses() {
//		return classes;
//	}
//	public void setClasses(Set<Classes> classes) {
//		this.classes = classes;
//	}
	public Set<Profession> getProfessions() {
		return professions;
	}
	public void setProfessions(Set<Profession> professions) {
		this.professions = professions;
	}
}
