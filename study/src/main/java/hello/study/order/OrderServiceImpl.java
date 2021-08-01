package hello.study.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.study.discount.DiscountPolicy;
import hello.study.discount.FixDiscountPolicy;
import hello.study.discount.RateDiscountPolicy;
import hello.study.member.Member;
import hello.study.member.MemberRepository;
import hello.study.member.MemoryMemberRepository;
@Component
public class OrderServiceImpl implements OrderService {
	private final MemberRepository memberRepository;// = new MemoryMemberRepository();
	//private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
	private final DiscountPolicy discountPolicy;// = new RateDiscountPolicy();// DIP 위반!!
	@Autowired
	public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}
	
	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		// TODO Auto-generated method stub
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);
		
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}
	
	//테스트용
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}
}
