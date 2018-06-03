package bean;

import java.sql.Timestamp;

/**
 * 考勤记录
 * @author yan
 *
 */
public class Timecard {
	private Long id;//记录编号
	private Student student;//谁的记录
	private Timestamp time;//签到时间
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
}
