package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import bean.Student;

public interface StudentDao {
	void add(Student stu);
	Student getStudent(DetachedCriteria dc);
	List<Student> getStudentList(DetachedCriteria dc);
	Long getStudentTotalCount();
	Long getStudentCount(DetachedCriteria dc);
	/**
	 * 分页查询
	 * @param dc
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	List<Student> getStudentList(DetachedCriteria dc,int currentPage,int pageSize);
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
