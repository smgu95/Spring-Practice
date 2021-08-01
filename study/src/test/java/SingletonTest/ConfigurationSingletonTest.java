package SingletonTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.study.AppConfig;
import hello.study.member.MemberRepository;
import hello.study.member.MemberServiceImpl;
import hello.study.order.OrderServiceImpl;

public class ConfigurationSingletonTest {
	
	@Test
	void configurationTest() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
		OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
		MemberRepository memberRepository =ac.getBean("memberRepository", MemberRepository.class);
		
		MemberRepository memberRepository1 = memberService.getMemberRepository();
		MemberRepository memberRepository2 = orderService.getMemberRepository();
		
		System.out.println("memberSerive -> memberRepository = " + memberRepository1);
		System.out.println("orderService -> memberRepository = " + memberRepository2);
		System.out.println("memberRepository = " + memberRepository);
//		memberSerive -> memberRepository = member.MemoryMemberRepository@13f95696
//		orderService -> memberRepository = member.MemoryMemberRepository@13f95696
//		memberRepository = member.MemoryMemberRepository@13f95696
		
		Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
		Assertions.assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
	}
		
	@Test
	void configurationDeep() {
	 ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	 //AppConfig도 스프링 빈으로 등록된다.
	 AppConfig bean = ac.getBean(AppConfig.class);
	 
	 System.out.println("bean = " + bean.getClass());
	 //출력: bean = class hello.core.AppConfig$$EnhancerBySpringCGLIB$$b38bd333
	}
	
	
}
