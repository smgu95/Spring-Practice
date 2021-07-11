package beanfind;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import discount.DiscountPolicy;
import discount.FixDiscountPolicy;
import discount.RateDiscountPolicy;


public class ApplicationContextExtensFindTest {
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConifg.class);
	
	@Test
	@DisplayName("�θ� Ÿ������ ��ȸ�� �ڽ��� �� �̻� ������,�ߺ� ���� �߻�.")
	void findBeanParentTypeDuplicate() {
		Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(DiscountPolicy.class));
	}
	
	@Test
	@DisplayName("�θ� Ÿ������ ��ȸ�� �ڽ��� �� �̻� ������,�� �̸��� �����ϸ� �ȴ�")
	void findBeanParentTypeBeanName() {
		DiscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy",DiscountPolicy.class);
		org.assertj.core.api.Assertions.assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
	}
	
	@Test
	@DisplayName("Ư�� ���� Ÿ������ ��ȸ")
	void findBeanBySubType() {
		RateDiscountPolicy rateDiscountPolicy = ac.getBean(RateDiscountPolicy.class);
		org.assertj.core.api.Assertions.assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
	}
	
	@Test
	@DisplayName("�θ� Ÿ������ ��� ��ȸ")
	void findBeanByParentType() {
		Map<String, DiscountPolicy> beanofType = ac.getBeansOfType(DiscountPolicy.class);
		org.assertj.core.api.Assertions.assertThat(beanofType.size()).isEqualTo(2);
		
		for(String key : beanofType.keySet()) {
			System.out.println("key = " + key + "\rvalue = "+ beanofType.get(key));
		}	
	}
	
	@Test
	@DisplayName("�θ� Ÿ������ ��� ��ȸ - Object")
	void findBeanByParentType_Object() {
		Map<String, Object> beanofType = ac.getBeansOfType(Object.class);
		for(String key : beanofType.keySet()) {
			System.out.println("key = " + key + "\rvalue = "+ beanofType.get(key));
		}	
	}
	
	
	@Configuration
	static class TestConifg{
		
		@Bean
		public DiscountPolicy rateDiscountPolicy() {
			return new RateDiscountPolicy();
		}
		
		@Bean
		public DiscountPolicy fixDiscountPolicy() {
			return new FixDiscountPolicy();
		}
	}
	
	
	
	
}
