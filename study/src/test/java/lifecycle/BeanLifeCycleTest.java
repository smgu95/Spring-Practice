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
		ac.close();  //ApplicationContext ��� AnnotationConfigApplicationContext ���� ����
	}
	@Configuration
	static class LifeCycleConfig{
		//@Bean(initMethod = "init", destroyMethod = "close")//destroyMethod�� ���� -> destroyMethod = "(inferred)" �̷������� ��������.. close�� shutdown�̶�� �޼��带 �ڵ����� ȣ�� ��.. �̹��� �ذ���) destroyMethod = "" �̷������� �ذ��������
		@Bean
		public NetworkClient networkClient() {
			NetworkClient networkClient = new NetworkClient();
			networkClient.setUrl("http://hello-spring.dev");
			return networkClient;
		}
	}
}
