package gukjin.springlecturebasic.beanTest;

import gukjin.springlecturebasic.discount.DiscountPolicy;
import gukjin.springlecturebasic.discount.FixDiscountPolicy;
import gukjin.springlecturebasic.discount.RateDiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationExtendsFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);


    @Test
    @DisplayName("부모 타입으로 조회 시, 자식이 둘 이상 있으면 중복 오류가 발생")
    void findBeanByParentTypeDuplicate(){
        assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(DiscountPolicy.class));
    }
    @Test
    @DisplayName("부모 타입으로 조회 시, 자식이 둘 이상 있으면 중복 오류가 발생하므로 빈 이름을 지정하면 된다")
    void findBeanByParentTypeBeanName(){
        DiscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);
        assertThat(rateDiscountPolicy).isInstanceOf(DiscountPolicy.class);
    }
    @Test
    @DisplayName("특정 하위 타입으로 조히")
    void findBeanBySubType(){
        RateDiscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy", RateDiscountPolicy.class);
        assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회")
    void findAllBeanByParentType(){
        Map<String, DiscountPolicy> discountPolicyMap = ac.getBeansOfType(DiscountPolicy.class);
        assertThat(discountPolicyMap.size()).isEqualTo(2);
        for (String key : discountPolicyMap.keySet()) {
            System.out.println("key = " + key + " values = " + discountPolicyMap.get(key));
        }
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회하기 - Object")
    void findAllBeanByObjectType(){
        Map<String, Object> discountPolicyMap = ac.getBeansOfType(Object.class);
        for (String key : discountPolicyMap.keySet()) {
            System.out.println("key = " + key + " values = " + discountPolicyMap.get(key));
        }
    }



    @Configuration
    static class TestConfig{
        @Bean
        public DiscountPolicy rateDiscountPolicy(){
            return new RateDiscountPolicy();
        }
        @Bean
        public DiscountPolicy fixDiscountPolicy(){
            return new FixDiscountPolicy();
        }
    }
}
