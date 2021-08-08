package hello.study.order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class helloLombok {
	private String name;
	private int age;
	
	public static void main(String[] args) {
		helloLombok hl = new helloLombok();
		hl.setName("123");
		
		
		String name = hl.getName();
		
		System.out.println(name);
		
		
	
		
	}
}
