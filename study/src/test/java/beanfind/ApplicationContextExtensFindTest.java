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
	@DisplayName("부모 타입으로 조회시 자식이 둘 이상 있으면,중복 오류 발생.")
	void findBeanParentTypeDuplicate() {
		Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(DiscountPolicy.class));
	}
	
	@Test
	@DisplayName("부모 타입으로 조회시 자식이 둘 이상 있으면,빈 이름을 지정하면 된다")
	void findBeanParentTypeBeanName() {
		DiscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy",DiscountPolicy.class);
		org.assertj.core.api.Assertions.assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
	}
	
	@Test
	@DisplayName("특정 하위 타입으로 조회")
	void findBeanBySubType() {
		RateDiscountPolicy rateDiscountPolicy = ac.getBean(RateDiscountPolicy.class);
		org.assertj.core.api.Assertions.assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
	}
	
	@Test
	@DisplayName("부모 타입으로 모두 조회")
	void findBeanByParentType() {
		Map<String, DiscountPolicy> beanofType = ac.getBeansOfType(DiscountPolicy.class);
		org.assertj.core.api.Assertions.assertThat(beanofType.size()).isEqualTo(2);
		
		for(String key : beanofType.keySet()) {
			System.out.println("key = " + key + "\rvalue = "+ beanofType.get(key));
		}	
	}
	
	@Test
	@DisplayName("부모 타입으로 모두 조회 - Object")
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
