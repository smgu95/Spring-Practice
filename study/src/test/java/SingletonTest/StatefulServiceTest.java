package SingletonTest;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {

	@Test
	void statefulServiceSingleton() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
		
		StatefulService statefulService1 = ac.getBean(StatefulService.class);
		StatefulService statefulService2 = ac.getBean(StatefulService.class);
		
		//ThreadA : A사용자 10000원 주문
		statefulService1.order("UserA", 10000);
		//ThreadB : B사용자 20000원 주문
		statefulService2.order("UserB", 20000);
		
		//ThreadA : A사용자 주문 금액 조회
		int price = statefulService1.getPrice();
		System.out.println("price = " + price);
		
		Assertions.assertThat(statefulService1.getPrice()).isEqualTo(statefulService2.getPrice());
		// --> a사용자는 분명 만원인데 b사용자랑 같게 나오는 문제가 생김!!
	}
	@Test
	@DisplayName("위 문제 해결방법")
	void statefulServiceSingletonFix() {
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
		
		StatefulService statefulService1 = ac.getBean(StatefulService.class);
		StatefulService statefulService2 = ac.getBean(StatefulService.class);
		
		//ThreadA : A사용자 10000원 주문
		int userAPrice = statefulService1.order2("UserA", 10000);
		//ThreadB : B사용자 20000원 주문
		int userBPrice = statefulService2.order2("UserB", 20000);
		
		//ThreadA : A사용자 주문 금액 조회
		
		System.out.println("price = " + userAPrice);
		
		Assertions.assertThat(userAPrice).isNotEqualTo(userBPrice);
		
	}
	
	static class TestConfig{
		@Bean
		public StatefulService statefulService() {
			return new StatefulService();
		}
	}

}
