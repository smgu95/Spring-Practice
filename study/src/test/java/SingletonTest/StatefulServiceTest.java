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
		
		//ThreadA : A����� 10000�� �ֹ�
		statefulService1.order("UserA", 10000);
		//ThreadB : B����� 20000�� �ֹ�
		statefulService2.order("UserB", 20000);
		
		//ThreadA : A����� �ֹ� �ݾ� ��ȸ
		int price = statefulService1.getPrice();
		System.out.println("price = " + price);
		
		Assertions.assertThat(statefulService1.getPrice()).isEqualTo(statefulService2.getPrice());
		// --> a����ڴ� �и� �����ε� b����ڶ� ���� ������ ������ ����!!
	}
	@Test
	@DisplayName("�� ���� �ذ���")
	void statefulServiceSingletonFix() {
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
		
		StatefulService statefulService1 = ac.getBean(StatefulService.class);
		StatefulService statefulService2 = ac.getBean(StatefulService.class);
		
		//ThreadA : A����� 10000�� �ֹ�
		int userAPrice = statefulService1.order2("UserA", 10000);
		//ThreadB : B����� 20000�� �ֹ�
		int userBPrice = statefulService2.order2("UserB", 20000);
		
		//ThreadA : A����� �ֹ� �ݾ� ��ȸ
		
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
