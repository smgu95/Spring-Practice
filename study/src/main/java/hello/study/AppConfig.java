package hello.study;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.study.discount.DiscountPolicy;
import hello.study.discount.FixDiscountPolicy;
import hello.study.discount.RateDiscountPolicy;
import hello.study.member.MemberRepository;
import hello.study.member.MemberService;
import hello.study.member.MemberServiceImpl;
import hello.study.member.MemoryMemberRepository;
import hello.study.order.OrderService;
import hello.study.order.OrderServiceImpl;

@Configuration
public class AppConfig {
	
	//@Bean memberService -> new MemoryMemberRepository()
	//@Bean orderService ->  new MemoryMemberRepository()
	// --> 두개가 따로 쓰는데 이게 싱글톤에 위반이 되는거 아니야??
	
	@Bean
	public MemberRepository memberRepository() {
		System.out.println("call AppConfig.memberRepository");
		return new MemoryMemberRepository();
	}
	
	@Bean
	public MemberService memberService() {
		System.out.println("call AppConfig.MemberService");
		return new MemberServiceImpl(memberRepository());
	}
	
	@Bean
	public OrderService orderService() {
		System.out.println("call AppConfig.orderService");
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}
	
	@Bean
	public DiscountPolicy discountPolicy() {
		//return new FixDiscountPolicy(); 
		return new RateDiscountPolicy();
	}
	
}
