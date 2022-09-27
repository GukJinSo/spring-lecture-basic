package gukjin.springlecturebasic;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration // 컴포넌트 설정을 위한 어노테이션
@ComponentScan(
        // 아무것도 설정하지 않으면 기본값은 @ComponentScan 어노테이션이 있는 하위 패키지를 뒤진다.
        // 기본적으로 @SpringBootApplicaton이 컴포넌트 스캔 설정을 포함하고 있다.
        // 베이스 패키지 지정, 외부 라이브러리를 스캔하지 않았으면 할 때. ("1", "2"식으로 여러개도 지정 가능)
        basePackages = "gukjin.springlecturebasic",
        // 특정 클래스 기준으로 탐색
        // basePackageClasses = AutoAppConfig.class
        // AppConfig를 사용 막기 위한 어노테이션
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)

)

public class AutoAppConfig {


}
