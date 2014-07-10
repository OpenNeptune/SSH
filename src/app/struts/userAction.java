package app.struts;


import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import app.model.User;
import app.service.UserService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;





@Controller("userAction")
@Scope("prototype")
public class userAction extends ActionSupport implements ModelDriven<User>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private UserService userService;
	
	private User user;
	
	public void setSupportService(UserService userService) {
		this.userService = userService;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

	@Override
	public String execute() throws Exception {
		userService.saveEntry(user);
		return SUCCESS;
	}
	@Override
	public User getModel() {
		return new User();
	}
	
}
