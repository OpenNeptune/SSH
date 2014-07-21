package core.struts.Action;

import javax.annotation.Resource;




import lombok.Getter;
import lombok.Setter;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import core.model.EntryPage;
import core.model.User;
import core.service.UserService;
import core.util.sec;

/**
 * @Summary
 * 	处理User相关的Action
 * 
 *  一般会在該方法中定义业务实体对应的主键字段
 *  另外在actionMethod被调用前可以使用
 *  	prepareExecActionName ()：在调用execActionName方法前提供一个Model对象
 *		validateExecActionName():在调用execActionName前做输入校验
 *
 */
@Controller("userAction")
@Scope("prototype")
public class userAction extends SupportAction<User> {

	private static final long serialVersionUID = 1130308026828193803L;

	@Getter @Setter private String registerCode;

	@Getter @Setter  private String confirPassword;
	
	@Getter @Setter private Integer userid;
	
	@Getter @Setter private EntryPage pageList;
	
	@Resource(name="userService") 
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

	
   /**
    * 修改用户资料
    */
	public void prepareExec_edit(){
		model = userService.get(userid);
	}
	
	public String exec_edit(){
		return "edit";
	}
	
	/**
	 * 罗列用户
	 * @return
	 */
	public String exec_list(){
		pageList = userService.query(1,100);
		return "list";
	}
	
}
