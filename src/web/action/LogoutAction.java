package web.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		//ActionContext.getContext().getSession().clear();
		ServletActionContext.getRequest().getSession().invalidate();
		System.out.println("web.action.LogoutAction:"+"已经销毁session");
		return "toLogin";
	}
}
