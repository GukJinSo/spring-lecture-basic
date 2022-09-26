package gukjin.springlecturebasic.singleton;

import gukjin.springlecturebasic.config.AppConfig;
import gukjin.springlecturebasic.member.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class SingletonTest {

    @Test
    @DisplayName("스프링이 없는 순수한 DI 컨테이너의 문제점 확인")
    void pureContainer() {

        AppConfig appConfig = new AppConfig();
        // 호출할 때마다 객체가 생성됨
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();
        //참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //memberService != memberService2
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴 적용")
    void singletonServiceTest(){
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();
        Assertions.assertThat(singletonService1).isSameAs(singletonService2);

    }
}
