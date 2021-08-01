package hello.study.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
@Component
public class MemoryMemberRepository implements MemberRepository {

	private static Map<Long, Member> store = new HashMap<>();
	private static Map<String, Member> store2 = new HashMap<>();
	private static Map<Grade,Member> store3 = new HashMap<>();
	
	@Override
	public void save(Member member) {
		// TODO Auto-generated method stub
		store.put(member.getId(),member);
		store2.put(member.getName(), member);
		store3.put(member.getGrade(), member);
	}
	@Override
	public Member findById(Long memberId) {
		// TODO Auto-generated method stub
		return store.get(memberId);
	}

	@Override
	public Member findByName(String memberName) {
		// TODO Auto-generated method stub
		return store2.get(memberName);
	}
	

}
