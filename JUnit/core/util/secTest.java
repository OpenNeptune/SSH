package core.util;

import org.junit.Test;


public class secTest {

	@Test
	public void md5Test(){
		System.out.println(sec.md5("123456"));
		System.out.println(sec.md5(""));
	}

}
