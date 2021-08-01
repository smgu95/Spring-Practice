package SingletonTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.study.AppConfig;
import hello.study.member.MemberService;

public class SingletonTest {
	
	
	@Test
	@DisplayName("스프링 없는 순수한 DI 컨테이너")
	void pureContainer() {
		AppConfig appConfig = new AppConfig();
		//1. 조회: 호출할 때 마다 객체를 생성
		MemberService memberService1 = appConfig.memberService();
		
		//2. 조회: 호출할 때 마다 객체를 생성
		MemberService memberService2 = appConfig.memberService();
		
		//참조값이 다른 것을 확인
		System.out.println("MemberService1 = "  + memberService1); //MemberService1 = member.MemberServiceImpl@59662a0b
		System.out.println("MemberService2 = "  + memberService2); //MemberService2 = member.MemberServiceImpl@77fbd92c
		
		Assertions.assertThat(memberService1).isNotSameAs(memberService2);

	}
	
	
	@Test
	@DisplayName("싱글톤 패턴을 적용한 객체 사용")
	void singletonServiceTest() {
		
		//SingletonService singletonService = new SingletonService(); --> 사용하면 당연히 되지않음 싱글톤패턴을 적용했기 때문 The constructor SingletonService() is not visible
		
		SingletonService singletonService1 = SingletonService.getinstance();
		SingletonService singletonService2 = SingletonService.getinstance();
		
		System.out.println("singletonService1 = "  + singletonService1); //singletonService1 = SingletonTest.SingletonService@49139829
		System.out.println("singletonService2 = "  + singletonService2); //singletonService2 = SingletonTest.SingletonService@49139829
		
		Assertions.assertThat(singletonService1).isSameAs(singletonService2); //isequal--> java의 equals라 생각 issame--> ==
		
	}
	
	@Test
	@DisplayName("스프링 컨테이너와 싱글톤")
	void springContainer() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		
		MemberService memberService1 = ac.getBean("memberService",MemberService.class);
		MemberService memberService2 = ac.getBean("memberService",MemberService.class);
		
		
		System.out.println("MemberService1 = "  + memberService1); //MemberService1 = member.MemberServiceImpl@cd1d761
		System.out.println("MemberService2 = "  + memberService2); //MemberService2 = member.MemberServiceImpl@cd1d761
		
		Assertions.assertThat(memberService1).isSameAs(memberService2);

	}
			
}
