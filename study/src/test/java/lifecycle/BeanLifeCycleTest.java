package lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {
	
	@Test
	public void lifeCycleTest() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
		NetworkClient networkClient  = ac.getBean(NetworkClient.class);
//		networkClient.setUrl("http://hello-spring.dev");
//		networkClient.connect();
//		networkClient.call("ADSdasdasd");
//		networkClient.disconnect();
		ac.close();  //ApplicationContext 대신 AnnotationConfigApplicationContext 쓰는 이유
	}
	@Configuration
	static class LifeCycleConfig{
		//@Bean(initMethod = "init", destroyMethod = "close")//destroyMethod의 문제 -> destroyMethod = "(inferred)" 이런식으로 잡혀있음.. close나 shutdown이라는 메서드를 자동으로 호출 함.. 이문제 해결방법) destroyMethod = "" 이런식으로 해결해줘야함
		@Bean
		public NetworkClient networkClient() {
			NetworkClient networkClient = new NetworkClient();
			networkClient.setUrl("http://hello-spring.dev");
			return networkClient;
		}
	}
}
