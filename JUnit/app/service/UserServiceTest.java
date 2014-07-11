package app.service;

import org.junit.Test;

import app.service.impl.UserServiceImpl;

public class UserServiceTest extends app.Test{

	@Test
	public void test() {
		
		UserService userService =(UserService) Context.getBean("userService");
		
		UserServiceImpl impl =(UserServiceImpl)userService;
		System.out.println(impl.getClass()+"\t"+impl.getSupportDao());
	}

}
