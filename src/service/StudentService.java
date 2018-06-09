package service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import bean.Student;
import utils.Pager;

public interface StudentService {
	void add(Student stu);
	Serializable save(Student stu);
	Student findByUsernameAndPasswd(Student stu);
	Student findById(Long id);
	void delete(Student stu);
	void update(Student stu);
	List<Student> findAllStudents();
	List<Student> findStudentsByCriteria(DetachedCriteria dc);
	Pager<Student> findStudentsPagerByCriteria(DetachedCriteria dc,int currentPage,int pageSize);
	String getAllStudentsToJson();
	
	List<?> getStudentsCountGroupByGoingName();
	List<?> getStudentsCountGroupByGoingRecordAddress();
}
