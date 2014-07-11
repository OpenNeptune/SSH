package app.service;

import app.model.User;
import core.service.SupportService;
/***
 * 
 * @sumary:
 * 		主要用于扩展
 */
public interface UserService extends SupportService<User> {
	public void save(User user);
	
	//判断该用户名是否可以注册
	public boolean isRegisterByName(String username);
	
	//判断是否是一个可用的邮箱地址
	public boolean isRegisterByEmail(String emial);
	
	//判断是否可以使用用户和密码进行登录
	public boolean vaildateLogin(String username,String password);
	
	
}
