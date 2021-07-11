package discount;

import member.Grade;
import member.Member;

public class FixDiscountPolicy implements DiscountPolicy{
	private int discountFixAmount = 1000;
	
	@Override
	public int discount(Member member, int Price) {
		// TODO Auto-generated method stub
		if(member.getGrade() == Grade.VIP) return discountFixAmount;
		else return 0;
	}
	

}
