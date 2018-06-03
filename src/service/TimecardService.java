package service;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import bean.Student;
import bean.Timecard;

public interface TimecardService {
	void save(Timecard timecard);
	void delete(Long id);
	void update(Timecard timecard);
	Timecard get(Long id);
	List<Timecard> get(DetachedCriteria dc);
	List<Timecard> getByStudent(Student stu);
	List<Timecard> getByDate(Date date);
	List<?> getByStudentAndDate(Student stu,Date date);
	List<Student> getSignedStudentByDate(Date date);
	List<Student> getUnsignedStudentByDate(Date date);
	List<Timecard> getSignedDaysByStudentAndMonth(Student stu,Date date);
}
