package app.struts.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import app.model.User;
import app.service.UserService;
import core.struts.Action.SupportAction;
import core.util.sec;


@Controller("userAction")
@Scope("prototype")
public class userAction extends SupportAction<User> {

	private static final long serialVersionUID = 1130308026828193803L;

	private String registerCode;
	
	private String confirPassword;
	
	@Resource
	private UserService userService;
	
	/**
	 * 跳转到用户注册页面 
	 */
	public String exec_tregister(){
		return "register";
	}
	
	/**
	 * 用户注册
	 */
	public String exec_register(){
		String result=SUCCESS;
		if(userService.isRegisterByName(model.getUsername())){
			model.setPassword(sec.md5(model.getPassword()));
			userService.save(model);
		}else{
			addFieldError("username", "用户名已经存在");
			result="input";
		}
		return result;
	}

	public String getRegisterCode() {
		return registerCode;
	}

	public void setRegisterCode(String registerCode) {
		this.registerCode = registerCode;
	}

	public String getConfirPassword() {
		return confirPassword;
	}

	public void setConfirPassword(String confirPassword) {
		this.confirPassword = confirPassword;
	}
	
	

}
