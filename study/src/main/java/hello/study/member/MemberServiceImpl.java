package hello.study.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{
	
	
	private final MemberRepository memberRepository;
	
	@Autowired // ac.getBean(memberRepository.class)
	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Override
	public void join(Member member) {
		// TODO Auto-generated method stub
		memberRepository.save(member);
	}

	@Override
	public Member findMember(Long memberId) {
		// TODO Auto-generated method stub
		return memberRepository.findById(memberId);
	}

	@Override
	public Member findName(String memberName) {
		// TODO Auto-generated method stub
		return memberRepository.findByName(memberName);
	}
	//테스트용
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}
}
