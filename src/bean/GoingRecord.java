package bean;
//去向记录

import java.sql.Timestamp;

public class GoingRecord {
	private Long goingRecordId;
	private Student student;
	private Going going;//去向
	private Timestamp leavingTime;//离校时间
	private Timestamp returningTime;//返校时间
	
	private String workName;//单位名称
	private String workLinkmanName;//联系人
	private String workTel;//单位联系电话
	private String workAddress;//单位地址
	public String getWorkName() {
		return workName;
	}
	public void setWorkName(String workName) {
		this.workName = workName;
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
	public String getWorkLinkmanName() {
		return workLinkmanName;
	}
	public void setWorkLinkmanName(String workLinkmanName) {
		this.workLinkmanName = workLinkmanName;
	}
	
	private String remark;//备注
	public Long getGoingRecordId() {
		return goingRecordId;
	}
	public void setGoingRecordId(Long goingRecordId) {
		this.goingRecordId = goingRecordId;
	}
//	public Student getStudent() {
//		return student;
//	}
//	public void setStudent(Student student) {
//		this.student = student;
//	}
	public Going getGoing() {
		return going;
	}
	public void setGoing(Going going) {
		this.going = going;
	}
	public Timestamp getLeavingTime() {
		return leavingTime;
	}
	public void setLeavingTime(Timestamp leavingTime) {
		this.leavingTime = leavingTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Timestamp getReturningTime() {
		return returningTime;
	}
	public void setReturningTime(Timestamp returningTime) {
		this.returningTime = returningTime;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
}
