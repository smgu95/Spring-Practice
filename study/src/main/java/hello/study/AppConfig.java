package hello.study;

import discount.DiscountPolicy;
import discount.FixDiscountPolicy;
import discount.RateDiscountPolicy;
import member.MemberRepository;
import member.MemberService;
import member.MemberServiceImpl;
import member.MemoryMemberRepository;
import order.OrderService;
import order.OrderServiceImpl;

public class AppConfig {
	
	private MemberRepository memberRepository() { // AOP 중복 리팩터링
		return new MemoryMemberRepository();
	}
	
	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository());
	}
	
	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}
	
	public DiscountPolicy discountPolicy() {
		//return new FixDiscountPolicy(); // 정률로 할지 비율로 할지 선택가능
		return new RateDiscountPolicy();
	}
	
}
