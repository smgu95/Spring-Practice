package hello.study.annotation;

import java.lang.annotation.*;
import org.springframework.beans.factory.annotation.Qualifier;

import hello.study.discount.RateDiscountPolicy;


@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy {
	 
}
