package hello.study.member;

public interface MemberService {
	
	void join(Member member);
	Member findMember(Long memberId);
	Member findName(String memberName);
}
