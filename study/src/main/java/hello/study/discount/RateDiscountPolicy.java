package hello.study.discount;

import org.springframework.stereotype.Component;

import hello.study.annotation.MainDiscountPolicy;
import hello.study.member.Grade;
import hello.study.member.Member;
@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {
	
	private int discountPercent = 10;

	@Override
	public int discount(Member member, int Price) {
		// TODO Auto-generated method stub
		if(member.getGrade() == Grade.VIP) return Price*discountPercent/100;
		else return 0;
			
	}
	
}
