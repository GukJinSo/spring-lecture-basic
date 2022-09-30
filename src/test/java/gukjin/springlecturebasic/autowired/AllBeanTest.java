package gukjin.springlecturebasic.autowired;

import gukjin.springlecturebasic.AutoAppConfig;
import gukjin.springlecturebasic.discount.DiscountPolicy;
import gukjin.springlecturebasic.member.domain.Grade;
import gukjin.springlecturebasic.member.domain.Member;
import gukjin.springlecturebasic.member.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class AllBeanTest {

    @Test
    void findAllBean(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);
        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L, "gukjin", Grade.VIP);
        int discountPrice = discountService.discount(member, 10000, discountPolicy.FIX.toString());
        Assertions.assertThat(discountPrice).isEqualTo(1000);

        int discountPrice2 = discountService.discount(member, 20000, discountPolicy.RATE.toString());
        Assertions.assertThat(discountPrice2).isEqualTo(2000);
    }

    enum discountPolicy{
        FIX {
            @Override
            public String toString() {
                return "fixDiscountPolicy";
            }
        },
        RATE {
            @Override
            public String toString() {
                return "rateDiscountPolicy";
            }
        }
    }

    static class DiscountService{
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        @Autowired
        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);
        }

        private int discount(Member member, int price, String discountMethod){
            return policyMap.get(discountMethod).discount(member, price);
        }
    }


}
