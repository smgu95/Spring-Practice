package hello.study;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import discount.DiscountPolicy;
import discount.FixDiscountPolicy;
import discount.RateDiscountPolicy;
import member.MemberRepository;
import member.MemberService;
import member.MemberServiceImpl;
import member.MemoryMemberRepository;
import order.OrderService;
import order.OrderServiceImpl;

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
