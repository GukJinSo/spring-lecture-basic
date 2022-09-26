package gukjin.springlecturebasic.beanTest;

import gukjin.springlecturebasic.member.repository.MemberRepository;
import gukjin.springlecturebasic.member.repository.MemoryMemberRepository;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class ApplicationContextSameBeanTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("중복 빈인 경우 에러 예상")
    void findBeanByTypeDuplicate(){
        assertThrows(NoUniqueBeanDefinitionException.class, () -> {
            ac.getBean(MemberRepository.class);
        });
    }

    @Test
    @DisplayName("중복 빈인 경우, 빈 이름 따로 지정")
    void sameBeanTest(){
        MemberRepository memberRepository = ac.getBean("memberRepository1", MemberRepository.class);
        assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }

    @Test
    @DisplayName("특정 타입을 모두 조회를 원할 때")
    void findAllBeanByType(){
        Map<String, MemberRepository> map = ac.getBeansOfType(MemberRepository.class);
        for (String key : map.keySet()) {
            System.out.println("key = " + key + "value = " + map.get(key));
        }
        System.out.println("map = " + map);
        assertThat(map.size()).isEqualTo(2);
    }

    @Configuration
    static class SameBeanConfig {

        @Bean
        public MemberRepository memberRepository1(){
            return new MemoryMemberRepository();
        }
        @Bean
        public MemberRepository memberRepository2(){
            return new MemoryMemberRepository();
        }
    }

}
