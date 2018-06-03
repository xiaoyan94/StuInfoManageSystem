package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import bean.Student;

public interface StudentDao {
	void add(Student stu);
	Student getStudent(DetachedCriteria dc);
	List<Student> getStudentList(DetachedCriteria dc);
	Serializable save(Student stu);
	void update(Student stu);
	void delete(Student stu);
	Student findByUsernameAndPasswd(Student stu);
	/**
	 * count(*)
	 * @return
	 */
	List<?> getStudentsGroupByGoingName();
	List<?> getStudentsGroupByGoingRecordAddress();
	
}
