package beanfind;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.study.member.MemberRepository;
import hello.study.member.MemoryMemberRepository;

public class ApplicationContextSameBeanFindTest {
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConifg.class);
	
	@Test
	@DisplayName("Ÿ������ ��ȸ�� ���� Ÿ���� �� �̻� ������, �ߺ� ������ �߻�")
	void findBeanByTypeDuplicate() {
		//MemberRepository bean = ac.getBean(MemberRepository.class);
		assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(MemberRepository.class));
	}
	
	@Test
	@DisplayName("Ÿ������ ��ȸ�� ���� Ÿ���� �� �̻� ������,�� �̸��� �����ϸ� �ȴ�.")
	void findBeanByName() {
		MemberRepository memberRepository = ac.getBean("memberRepository1",MemberRepository.class);
		org.assertj.core.api.Assertions.assertThat(memberRepository).isInstanceOf(MemberRepository.class);
	}
	
	@Test
	@DisplayName("Ư�� Ÿ���� ��� ��ȸ�ϱ�")
	void findAllBeanByType() {
		Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
		for(String key : beansOfType.keySet()) {
			System.out.println("key = " + key + " value = " + beansOfType.get(key));
		}
		System.out.println("beansOfType = " + beansOfType);
		org.assertj.core.api.Assertions.assertThat(beansOfType.size()).isEqualTo(2);
		
	}
	
	
	
	@Configuration
	static class SameBeanConifg{
		
		@Bean
		public MemberRepository memberRepository1() {
			return new MemoryMemberRepository();
		}
		
		@Bean
		public MemberRepository memberRepository2() {
			return new MemoryMemberRepository();
		}
	}
	

}
