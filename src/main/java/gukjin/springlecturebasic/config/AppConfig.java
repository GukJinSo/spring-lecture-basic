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

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
