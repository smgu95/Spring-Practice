package lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
public class NetworkClient{
	private String url;
	
	public NetworkClient() {
		System.out.println("생성자 호출, url = " + url);
//		connect();
//		call("초기화 연결 메시지");
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
	//거의사용하지않음 implements InitializingBean,DisposableBean {
//	@Override
//	public void afterPropertiesSet() throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("networkClient.afterPropertiesSet");
//		connect();
//		call("초기화연결 메시지");
//	}
//
//	@Override
//	public void destroy() throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("networkClient.DisposableBean");
//		disconnect();
//	}
	
//	거의사용하지않음 @Bean(initMethod = "init", destroyMethod = "close") 
//	public void init() {
//		System.out.println("networkClient.init");
//		connect();
//		call("초기화연결 메시지");
//	}
//
//	public void close() {
//		System.out.println("networkClient.close");
//		disconnect();
//	}
	//spring 권장하는 방법
	@PostConstruct
	public void init() {
		System.out.println("networkClient.init");
		connect();
		call("초기화연결 메시지");
	}
	@PreDestroy
	public void close() {
		System.out.println("networkClient.close");
		disconnect();
	}
}
