package test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.study.AppConfig;
import hello.study.member.*;
import hello.study.order.*;

public class OrderServiceTest {
	
	MemberService memberService;
	OrderService orderService;
	
	@BeforeEach
	public void beforeEach() {
		AppConfig appConfig = new AppConfig();
		memberService = appConfig.memberService();
		orderService = appConfig.orderService();
	}
	
	@Test
	void createOrder() {
		Long memberId = 1L;
		Member member = new Member(memberId, "A", Grade.VIP);
		memberService.join(member);
		
		Order order = orderService.createOrder(memberId, "itemA", 99000);
		Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
	}
	
}
