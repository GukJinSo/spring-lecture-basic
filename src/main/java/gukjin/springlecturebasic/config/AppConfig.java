package gukjin.springlecturebasic.config;

import gukjin.springlecturebasic.discount.DiscountPolicy;
import gukjin.springlecturebasic.discount.FixDiscountPolicy;
import gukjin.springlecturebasic.discount.RateDiscountPolicy;
import gukjin.springlecturebasic.member.repository.MemberRepository;
import gukjin.springlecturebasic.member.repository.MemoryMemberRepository;
import gukjin.springlecturebasic.member.service.MemberService;
import gukjin.springlecturebasic.member.service.MemberServiceImpl;
import gukjin.springlecturebasic.order.OrderService;
import gukjin.springlecturebasic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
