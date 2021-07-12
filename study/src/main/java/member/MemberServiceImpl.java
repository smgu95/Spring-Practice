package member;

public class MemberServiceImpl implements MemberService{
	
	
	private final MemberRepository memberRepository;
	
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
