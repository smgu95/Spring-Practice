package hello.study;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan
(
		basePackages =  "hello.study.discount",//������ ��Ű���θ�
		basePackageClasses = AutoAppConfig.class,//�� ��Ű����
		
		// ������ �ȵǾ������� package hello.study; �길 ���� �׷��� �Ʊ� ��Ű�� member,order�� �˻��� �ȉ������ 
		excludeFilters = @Filter(type = FilterType.ANNOTATION,classes = Configuration.class)
)
public class AutoAppConfig {
	
}
