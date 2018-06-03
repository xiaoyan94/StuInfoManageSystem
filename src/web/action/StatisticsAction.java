package web.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;

import service.StudentService;

public class StatisticsAction extends ActionSupport {
	private JSONArray dataJson;
	private StudentService studentService;
	private static final long serialVersionUID = 1L;

	public String goingJson() throws Exception {
		setJsonArray(new JSONArray());
		@SuppressWarnings("unchecked")
		List<Object[]> groupByGoingName = (List<Object[]>) studentService.getStudentsCountGroupByGoingName();
		for (Object[] objects : groupByGoingName) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("name", objects[0]);
			jsonObject.put("value", objects[1]);
			getJsonArray().add(jsonObject);
		}
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("value", 15);
//		jsonObject.put("name", "实习");
//		getJsonArray().add(jsonObject);
//		jsonObject = new JSONObject();
//		jsonObject.put("value", 18);
//		jsonObject.put("name", "工作");
//		getJsonArray().add(jsonObject);
//		jsonObject = new JSONObject();
//		jsonObject.put("value", 20);
//		jsonObject.put("name", "实训");
//		getJsonArray().add(jsonObject);
//		jsonObject = new JSONObject();
//		jsonObject.put("value", 10);
//		jsonObject.put("name", "其他");
		String json = getJsonArray().toJSONString();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
		return "json";
	}
	
	public String goingAddressJson() throws Exception {
		setJsonArray(new JSONArray());
		@SuppressWarnings("unchecked")
		List<Object[]> groupByAddress = (List<Object[]>) studentService.getStudentsCountGroupByGoingRecordAddress();
		JSONArray xAxis = new JSONArray();
		for (Object[] objects : groupByAddress) {
			xAxis.add(objects[0]);
			getJsonArray().add(objects[1]);
		}
		JSONObject result = new JSONObject();
		result.put("xAxis", xAxis);
		result.put("data", getJsonArray());
		String json = result.toJSONString();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
		return "json";
	}
	
	public String show() {
		
		return "show";
	}

	public JSONArray getJsonArray() {
		return dataJson;
	}

	public void setJsonArray(JSONArray jsonArray) {
		this.dataJson = jsonArray;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

}
