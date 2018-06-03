package web.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {

	private static final long serialVersionUID = 1L;
	//指定不拦截登陆方法. 其他方法都拦截
	
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		System.out.println("登录验证拦截器开始");
		//1.获得session
		HttpSession session = ServletActionContext.getRequest().getSession();
		//2.获得登陆标识
		if(session==null) {
			System.out.println("登录验证拦截器  session为空");
			return "toLogin";
		}else {
			Object object = session.getAttribute("user");
			//3.判断登陆标识是否存在
			if(object == null){
				//ActionContext重定向时无法共享数据
				//ActionContext.getContext().put("msg", "登录验证拦截：session中没有用户");
				session.setAttribute("msg", "请登录后操作");
				//不存在=>没登录=>重定向到登录页面
				System.out.println("登录验证拦截器  session中没有用户");
				return "toLogin";
			}else{
				//存在=>已经登陆=>放行
				System.out.println("登录验证拦截器  session中有用户 已登录放行");
				String invoke = invocation.invoke();
				return invoke;
			}
		}
	}
	
	

}
