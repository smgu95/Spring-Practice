package scope;

import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;


public class PrototypeTest {
	@Test
	void prototypebeanFind(){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(prototypeBean.class);
		System.out.println("find prototypeBean1");
		prototypeBean bean1 = ac.getBean(prototypeBean.class);
		System.out.println("find prototypeBean2");
		prototypeBean bean2 = ac.getBean(prototypeBean.class);
		
		System.out.println("prototypeBean1 = " + bean1);
		System.out.println("prototypeBean2 = " + bean2);
		assertThat(bean1).isNotSameAs(bean2);
		ac.close();
	}
	
	
	@Scope("prototype")
	static class prototypeBean{
		@PostConstruct
		public void init() {
			System.out.println("prototype.init");
		}
		@PreDestroy
		public void destroy() {
			System.out.println("prototype.destroy");
		}
	}
}


