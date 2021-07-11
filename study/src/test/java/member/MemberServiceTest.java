package member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.study.AppConfig;

public class MemberServiceTest {
	
	
	MemberService memberService;
	
	@BeforeEach
	public void beforeEach() {
		AppConfig appConfig = new AppConfig();
		memberService = appConfig.memberService();
	}
	
	@Test
	void join() {
		//given
		
		Member member = new Member(1L,"sfdafsd",Grade.BASIC);
		//when
		memberService.join(member);
		Member findMember = memberService.findMember(1L);
		//then
		
		Assertions.assertThat(member).isEqualTo(findMember);
	}
	@Test
	void join2() {
		//given
		
		Member member = new Member(3L,"2a",Grade.BASIC);
		//when
		memberService.join(member);
		Member findMember = memberService.findName("2a");
		//then
		Assertions.assertThat(member).isEqualTo(findMember);
	}
	
}
