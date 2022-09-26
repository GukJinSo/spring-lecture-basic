package gukjin.springlecturebasic;

import gukjin.springlecturebasic.config.AppConfig;
import gukjin.springlecturebasic.member.domain.Grade;
import gukjin.springlecturebasic.member.domain.Member;
import gukjin.springlecturebasic.member.domain.Order;
import gukjin.springlecturebasic.member.service.MemberService;
import gukjin.springlecturebasic.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        OrderService orderService = appConfig.orderService();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        memberService.join(new Member(1L, "memberA", Grade.VIP));

        Order order = orderService.createOrder(1L, "itemA", 10000);
        System.out.println(order.toString());


    }
}
