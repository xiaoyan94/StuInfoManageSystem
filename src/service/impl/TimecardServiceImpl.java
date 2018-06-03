package service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import bean.Student;
import bean.Timecard;
import dao.TimecardDao;
import service.TimecardService;

@Transactional
public class TimecardServiceImpl implements TimecardService {
	private TimecardDao timecardDao;

	public TimecardDao getTimecardDao() {
		return timecardDao;
	}

	public void setTimecardDao(TimecardDao timecardDao) {
		this.timecardDao = timecardDao;
	}

	@Override
	public void save(Timecard timecard) {
		timecardDao.save(timecard);
	}

	@Override
	public void delete(Long id) {
		timecardDao.delete(id);
	}

	@Override
	public void update(Timecard timecard) {
		timecardDao.update(timecard);
	}

	@Override
	public Timecard get(Long id) {
		return timecardDao.get(id);
	}

	@Override
	public List<Timecard> get(DetachedCriteria dc) {
		return timecardDao.get(dc);
	}

	@Override
	public List<Timecard> getByStudent(Student stu) {
		return timecardDao.getByStudent(stu);
	}

	@Override
	public List<Timecard> getByDate(Date date) {
		return timecardDao.getByDate(date);
	}

	@Override
	public List<?> getByStudentAndDate(Student stu, Date date) {
		return timecardDao.getByStudentAndDate(stu, date);
	}

	@Override
	public List<Student> getSignedStudentByDate(Date date) {
		return timecardDao.getSignedStudentsByDate(date);
	}

	@Override
	public List<Student> getUnsignedStudentByDate(Date date) {
		return timecardDao.getUnsignedStudentsByDate(date);
	}

	@Override
	public List<Timecard> getSignedDaysByStudentAndMonth(Student stu, Date date) {
		DetachedCriteria dc = DetachedCriteria.forClass(Timecard.class);
		dc.add(Restrictions.eq("student.id", stu.getId()));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		String format = sdf.format(date);
		Date start;
		Date end;
		try {
			start = sdf.parse(format);
			String[] split = format.split("-");
			int endMonth = Integer.valueOf(split[1]) + 1;
			String format2 = split[0] + "-" + endMonth;
			end = sdf.parse(format2);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		dc.add(Restrictions.between("time", start, end));
		return get(dc);
	}

}
