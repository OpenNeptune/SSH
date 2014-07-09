package struts;

import com.opensymphony.xwork2.ActionSupport;

public class configAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	@Override
	public String execute() throws Exception {
		System.out.println("TestAction::it's ok");
		return SUCCESS;
	}
	
}
