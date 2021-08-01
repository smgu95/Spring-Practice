package hello.study;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan
(
		basePackages =  "hello.study.discount",//지정한 패키지로만
		basePackageClasses = AutoAppConfig.class,//내 패키지만
		
		// 설정이 안되어있으면 package hello.study; 얘만 뒤짐 그래서 아까 패키지 member,order등 검색이 안됬던거임 
		excludeFilters = @Filter(type = FilterType.ANNOTATION,classes = Configuration.class)
)
public class AutoAppConfig {
	
}
