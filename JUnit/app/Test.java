package app;


import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public  ClassPathXmlApplicationContext Context;
	
	@Before
	public void before(){
		Context  = new ClassPathXmlApplicationContext("beans.xml");
	}
	
	@After
	public void after(){
		Context.close();
	}
	

}
