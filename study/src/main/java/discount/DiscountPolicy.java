package discount;

import member.Member;

public interface DiscountPolicy {
	/**
	 * 
	 * @param member
	 * @param Price
	 * @return 할인 대상 금액
	 */
	int discount(Member member, int Price);
	
}
