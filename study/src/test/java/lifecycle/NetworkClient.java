package lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
public class NetworkClient{
	private String url;
	
	public NetworkClient() {
		System.out.println("������ ȣ��, url = " + url);
//		connect();
//		call("�ʱ�ȭ ���� �޽���");
	}

	public void setUrl(String url) {
		this.url = url;
		
	}
	
	public void connect() {
		System.out.println("conntect : " + url);
	}
	public void call(String message) {
		System.out.println("call : "+url+" message = " + message);
	}
	public void disconnect() {
		System.out.println("close : " + url);
	}
	//���ǻ���������� implements InitializingBean,DisposableBean {
//	@Override
//	public void afterPropertiesSet() throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("networkClient.afterPropertiesSet");
//		connect();
//		call("�ʱ�ȭ���� �޽���");
//	}
//
//	@Override
//	public void destroy() throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("networkClient.DisposableBean");
//		disconnect();
//	}
	
//	���ǻ���������� @Bean(initMethod = "init", destroyMethod = "close") 
//	public void init() {
//		System.out.println("networkClient.init");
//		connect();
//		call("�ʱ�ȭ���� �޽���");
//	}
//
//	public void close() {
//		System.out.println("networkClient.close");
//		disconnect();
//	}
	//spring �����ϴ� ���
	@PostConstruct
	public void init() {
		System.out.println("networkClient.init");
		connect();
		call("�ʱ�ȭ���� �޽���");
	}
	@PreDestroy
	public void close() {
		System.out.println("networkClient.close");
		disconnect();
	}
}
