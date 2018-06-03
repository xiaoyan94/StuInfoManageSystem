package web.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import bean.Student;
import bean.Timecard;
import service.TimecardService;
import utils.IpUtils;

public class TimecardAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private TimecardService timecardService;
	private Map<String,Object> dataMap = new HashMap<>();
	/**
	 * 2018-05
	 */
	private String date;
	/**
	 * 查询最近10条签到记录
	 * @return
	 */
	public String listByStudent() {
		setDataMap(new HashMap<>());
		Map<String, Object> session = ActionContext.getContext().getSession();
		Student stu = (Student) session.get("student");
		List<Timecard> byStudent = timecardService.getByStudent(stu);
		dataMap.put("status", SUCCESS);
		if(!CollectionUtils.isEmpty(byStudent)) {
			dataMap.put("total", byStudent.size());
			List<Timestamp> times = new ArrayList<>();
			int i=0;
			for (Timecard timecard : byStudent) {
				if(i++<10) {
					times.add(timecard.getTime());
				}
			}
			dataMap.put("timecards", times);
		}else {
			dataMap.put("total", 0);
			dataMap.put("timecards", null);
		}
		return "json";
	}
	
	public String listByDate() {
		setDataMap(new HashMap<>());
		Date date = new Date();
		System.out.println(date);
		List<Timecard> byDate = timecardService.getByDate(date);
		dataMap.put("status", SUCCESS);
		dataMap.put("timecards", byDate);
		return "json";
	}
	public String getSignedStudents() {
		setDataMap(new HashMap<>());
		List<Student> signedStudentByDate = timecardService.getSignedStudentByDate(new Date());
		if(!CollectionUtils.isEmpty(signedStudentByDate)) {
			dataMap.put("status", SUCCESS);
		}else {
			dataMap.put("status", "failed");
		}
		List<Map<String,Object>> list = new ArrayList<>();
		for (Student student : signedStudentByDate) {
			Map<String,Object> map = new HashMap<>();
			map.put("id", student.getId());
			map.put("name",student.getName());
			map.put("sex",student.getSex());
			map.put("tel",student.getTel());
			Timecard t = (Timecard) timecardService.getByStudentAndDate(student,new Date()).get(0);
			map.put("time",t.getTime());
			if(student.getGoingRecord()!=null) {
				map.put("workName", student.getGoingRecord().getWorkName());
				map.put("workAddress", student.getGoingRecord().getWorkAddress());
				map.put("workTel", student.getGoingRecord().getWorkTel());
				map.put("workLinkmanName", student.getGoingRecord().getWorkLinkmanName());
				if(student.getGoingRecord().getGoing()!=null)
					map.put("goingName", student.getGoingRecord().getGoing().getName());
			}
			list.add(map);
		}
		dataMap.put("students", list);
		return "json";
	}
	public String getUnsignedStudents() {
		setDataMap(new HashMap<>());
		List<Student> signedStudentByDate = timecardService.getUnsignedStudentByDate(new Date());
		if(!CollectionUtils.isEmpty(signedStudentByDate)) {
			dataMap.put("status", SUCCESS);
		}else {
			dataMap.put("status", "failed");
		}
		List<Map<String,Object>> list = new ArrayList<>();
		for (Student student : signedStudentByDate) {
			Map<String,Object> map = new HashMap<>();
			map.put("id", student.getId());
			map.put("name",student.getName());
			map.put("sex",student.getSex());
			map.put("tel",student.getTel());
			if(student.getGoingRecord()!=null) {
				map.put("workName", student.getGoingRecord().getWorkName());
				map.put("workAddress", student.getGoingRecord().getWorkAddress());
				map.put("workTel", student.getGoingRecord().getWorkTel());
				map.put("workLinkmanName", student.getGoingRecord().getWorkLinkmanName());
				if(student.getGoingRecord().getGoing()!=null)
					map.put("goingName", student.getGoingRecord().getGoing().getName());
			}
			list.add(map);
		}
		dataMap.put("students", list);
		return "json";
	}
	/**
	 * 返回当日是否签到及签到时间
	 * @return
	 */
	public String listByStudentDate() {
		setDataMap(new HashMap<>());
		Date date = new Date();
		Map<String, Object> session = ActionContext.getContext().getSession();
		Student stu = (Student) session.get("student");
		//stu.setId(1408090213L);
		List<?> t = timecardService.getByStudentAndDate(stu,date);
		dataMap.put("status", SUCCESS);
		if(!CollectionUtils.isEmpty(t)) {
			dataMap.put("isSign", true);
			dataMap.put("time", ((Timecard)(t.get(0))).getTime());
		}else {
			dataMap.put("isSign", false);
			dataMap.put("time", null);
		}
		
		return "json";
	}
	/**
	 * 返回本月签到日子
	 * @return
	 */
	public String getSignedDays() {
		setDataMap(new HashMap<>());
		Map<String, Object> session = ActionContext.getContext().getSession();
		Student stu = (Student) session.get("student");
//		stu = new Student();
//		stu.setId(1408090213L);
		if(stu==null) {
			dataMap.put("status", "failed");
			return "json";
		}
		List<Timecard> list = timecardService.getSignedDaysByStudentAndMonth(stu, new Date());
		List<Map<String,Object>> days = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		Map<String, Object> map = new HashMap<>();
		for (Timecard timecard : list) {
			map = new HashMap<>();
			Date date = new Date(timecard.getTime().getTime());
			String day = sdf.format(date);
			map.put("signDay", Integer.valueOf(day)+"");
			days.add(map);
		}
		map.put("today", Integer.valueOf(sdf.format(new Date()))+"");
		dataMap.put("status", SUCCESS);
		dataMap.put("days", days);
		return "json";
	}
	/**
	 * 指定月份
	 * @return
	 */
	public String getSignedDaysByMonth() {
		setDataMap(new HashMap<>());
		Map<String, Object> session = ActionContext.getContext().getSession();
		Student stu = (Student) session.get("student");
		stu = new Student();
		stu.setId(1408090213L);
//		if(stu==null) {
//			dataMap.put("status", "failed");
//			return "json";
//		}
		SimpleDateFormat sdfMonth = new SimpleDateFormat("yyyy-MM");
		Date parseDate = new Date();
		try {
			parseDate = sdfMonth.parse(getDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<Timecard> list = timecardService.getSignedDaysByStudentAndMonth(stu, parseDate);
		List<Map<String,Object>> days = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		Map<String, Object> map = new HashMap<>();
		for (Timecard timecard : list) {
			map = new HashMap<>();
			Date date = new Date(timecard.getTime().getTime());
			String day = sdf.format(date);
			map.put("signDay", Integer.valueOf(day)+"");
			days.add(map);
		}
		map.put("today", Integer.valueOf(sdf.format(new Date()))+"");
		dataMap.put("status", SUCCESS);
		dataMap.put("days", days);
		return "json";
	}
	/**
	 * 使用session中的student进行签到
	 * @return
	 */
	public String sign() {
		setDataMap(new HashMap<>());
		//签到
		Map<String, Object> session = ActionContext.getContext().getSession();
		String remoteHost = ServletActionContext.getRequest().getRemoteAddr();
		System.out.println(remoteHost);
		JSONObject ipInfo = null;
		try {
			ipInfo = JSONObject.parseObject(IpUtils.getIpInfoJson("114.114.114.114"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Student stu = (Student) ActionContext.getContext().getSession().get("student");
		if(stu==null) {
			session.put("msg", "请进行登录才能签到");
			dataMap.put("msg", "请进行登录才能签到");
			dataMap.put("status", "failed");
			return "toLogin";
		}else if(ipInfo!=null&&!ipInfo.getString("city").equals("sahnghai")){
			//ip
			System.out.println("ip限制");
			dataMap.put("msg", "您的IP地址不允许签到");
			dataMap.put("status", "failed");
			dataMap.put("isSign", false);
		}else if(!CollectionUtils.isEmpty(timecardService.getByStudentAndDate(stu,new Date()))){
			//今日已经签到
			dataMap.put("msg", "今日已经签到过啦");
			dataMap.put("status", "failed");
			dataMap.put("isSign", true);
		}else {
			Timecard timecard = new Timecard();
			timecard.setStudent(stu);
			timecard.setTime(new Timestamp(System.currentTimeMillis()));
			timecardService.save(timecard );
			dataMap.put("status", "success");
		}
		return "json";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public TimecardService getTimecardService() {
		return timecardService;
	}
	public void setTimecardService(TimecardService timecardService) {
		this.timecardService = timecardService;
	}
	public Map<String,Object> getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map<String,Object> dataMap) {
		this.dataMap = dataMap;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
