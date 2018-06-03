package bean;

import java.util.Set;

public class Student {
	private Long id;//学号
	private String name;
	private Character sex;
	private String idCard;
	private String tel;
	private String passwd;
	private Classes classes;//学生所在班级
	private Set<Timecard> timecards;//学生对应考勤记录
	private GoingRecord goingRecord;//学生对应去向记录
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
	public Character getSex() {
		return sex;
	}
	public void setSex(Character sex) {
		this.sex = sex;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Classes getClasses() {
		return classes;
	}
	public void setClasses(Classes classes) {
		this.classes = classes;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public Set<Timecard> getTimecards() {
		return timecards;
	}
	public void setTimecards(Set<Timecard> timecards) {
		this.timecards = timecards;
	}
	public GoingRecord getGoingRecord() {
		return goingRecord;
	}
	public void setGoingRecord(GoingRecord goingRecord) {
		this.goingRecord = goingRecord;
	}
}
