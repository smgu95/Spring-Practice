package discount;

import member.Member;

public interface DiscountPolicy {
	/**
	 * 
	 * @param member
	 * @param Price
	 * @return ���� ��� �ݾ�
	 */
	int discount(Member member, int Price);
	
}
