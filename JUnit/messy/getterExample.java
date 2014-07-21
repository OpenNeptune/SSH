package messy;

import lombok.Getter;
import lombok.Setter;

public class getterExample {
	@Getter @Setter private Integer age =0;
	
	public static void main(String[] args) {
		getterExample test = new getterExample();
		System.out.println(test.getAge());
	}
}
