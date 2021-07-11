package discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import member.Grade;
import member.Member;

public class RateDiscountPolicyTest {
	
	RateDiscountPolicy discountPolicy = new RateDiscountPolicy();
	
	@Test
	@DisplayName("VIP�� 10% ������ ����Ǿ�� �Ѵ�.")
	void vip_o() {
		//given
		Member member = new Member(1L, "memberVIP", Grade.VIP);
		//when
		int discount = discountPolicy.discount(member, 10000);
		//then
		Assertions.assertThat(discount).isEqualTo(1000);
		
	}
	
	@Test
	@DisplayName("VIP�� �ƴϸ� ������� ���ƾ� �Ѵ�.")
	void vip_x() {
		//given
		Member member = new Member(1L, "memberVIP", Grade.BASIC);
		//when
		int discount = discountPolicy.discount(member, 10000);
		//then
		Assertions.assertThat(discount).isEqualTo(1000);
		
	}
	
}
