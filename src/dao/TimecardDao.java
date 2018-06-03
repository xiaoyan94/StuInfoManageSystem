package dao;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import bean.Student;
import bean.Timecard;

public interface TimecardDao {
	void save(Timecard timecard);
	void delete(Long id);
	void update(Timecard timecard);
	Timecard get(Long id);
	List<Timecard> get(DetachedCriteria dc);
	List<Timecard> getByStudent(Student stu);
	List<Timecard> getByDate(Date date);
	/**
	 * 
	 * @param stu
	 * @param date
	 * @return Timecard列表
	 */
	List<?> getByStudentAndDate(Student stu,Date date);
	List<Student> getSignedStudentsByDate(Date date);
	List<Student> getUnsignedStudentsByDate(Date date);
}
