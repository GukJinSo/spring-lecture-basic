package gukjin.springlecturebasic.scan;

import gukjin.springlecturebasic.AutoAppConfig;
import gukjin.springlecturebasic.member.service.MemberService;
import gukjin.springlecturebasic.member.service.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class AutoAppConfigTest {

    @Test
    @DisplayName("컴포넌트 스캔을 통한 자동 컨피그")
    void test(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        // Bean 이름을 직접 지정하려면 @Component("memberService")처럼 지정
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }

}
