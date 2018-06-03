package web.action;
import java.util.HashMap;
import java.util.List;
import java.util.Map;  
  
import org.apache.struts2.json.annotations.JSON;  
import com.opensymphony.xwork2.ActionSupport;

import bean.Student;
import bean.User;
import service.StudentService;  
  
/** 
 * JSON测试 
 *  
 * @author Watson Xu 
 * @date 2012-8-4 下午06:21:01 
 */  
public class JsonAction extends ActionSupport{  
    private static final long serialVersionUID = 1L;  
    
    private StudentService stuService;
    
    private Map<String,Object> dataMap;  
    private String key = "Just see see";  
      
    public String json() {  
        // dataMap中的数据将会被Struts2转换成JSON字符串，所以这里要先清空其中的数据  
    	dataMap = new HashMap<String, Object>();  
        User user = new User();  
        user.setUname("张三");  
        user.setUpasswd("111");  
        dataMap.put("user", user);  
        // 放入一个是否操作成功的标识  
        dataMap.put("success", true);  
        // 返回结果  
        return SUCCESS;  
    }  
    
    public String getAllStudents() {
    	dataMap = new HashMap<String, Object>();  
    	List<Student> students = stuService.findAllStudents();
    	dataMap.put("students", students);
    	dataMap.put("success", true);  
    	return SUCCESS;
    }
  
    public Map<String, Object> getDataMap() {  
        return dataMap;  
    }  
  
    //设置key属性不作为json的内容返回  
    @JSON(serialize=false)  
    public String getKey() {  
        return key;  
    }

	public StudentService getStuService() {
		return stuService;
	}

	public void setStuService(StudentService stuService) {
		this.stuService = stuService;
	}  
      
}  