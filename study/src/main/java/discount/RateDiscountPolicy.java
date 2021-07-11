package discount;

import member.Grade;
import member.Member;

public class RateDiscountPolicy implements DiscountPolicy {
	
	private int discountPercent = 10;

	@Override
	public int discount(Member member, int Price) {
		// TODO Auto-generated method stub
		if(member.getGrade() == Grade.VIP) return Price*discountPercent/100;
		else return 0;
			
	}
	
}
