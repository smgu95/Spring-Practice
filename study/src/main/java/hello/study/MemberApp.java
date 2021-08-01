package hello.study;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.study.member.Grade;
import hello.study.member.Member;
import hello.study.member.MemberService;
import hello.study.member.MemberServiceImpl;

public class MemberApp {
	
	public static void main(String[] args) {
		
//		AppConfig appConfig = new AppConfig();
//		MemberService memberService = appConfig.memberService();
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
		
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
