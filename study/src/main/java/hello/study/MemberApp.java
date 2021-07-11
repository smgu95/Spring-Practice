package hello.study;

import member.Grade;
import member.Member;
import member.MemberService;
import member.MemberServiceImpl;

public class MemberApp {
	
	public static void main(String[] args) {
		
		AppConfig appConfig = new AppConfig();
		
		MemberService memberService = appConfig.memberService();
		Member member = new Member(1L, "asdfasdf", Grade.VIP);
		memberService.join(member);
		
		Member findMember = memberService.findMember(1L);
		
		System.out.println(findMember.getName());
		System.out.println(member.getName());
		
		if(findMember.getName() != member.getName()) {
			System.out.println("Cannot find");
		} else{
			System.out.println("find");
		}
	}
}
