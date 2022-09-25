package gukjin.springlecturebasic;

import gukjin.springlecturebasic.config.AppConfig;
import gukjin.springlecturebasic.member.domain.Grade;
import gukjin.springlecturebasic.member.domain.Member;
import gukjin.springlecturebasic.member.domain.Order;
import gukjin.springlecturebasic.member.service.MemberService;
import gukjin.springlecturebasic.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        OrderService orderService = appConfig.orderService();
        MemberService memberService = appConfig.memberService();

        memberService.join(new Member(1L, "memberA", Grade.VIP));

        Order order = orderService.createOrder(1L, "itemA", 10000);
        System.out.println(order.toString());


    }
}
