package hello.study.discount;

import hello.study.member.Member;

public interface DiscountPolicy {
	/**
	 * 
	 * @param member
	 * @param Price
	 * @return ���� ��� �ݾ�
	 */
	int discount(Member member, int Price);
	
}
