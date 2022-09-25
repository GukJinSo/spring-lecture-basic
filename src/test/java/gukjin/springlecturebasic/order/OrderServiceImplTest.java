package gukjin.springlecturebasic.order;

import gukjin.springlecturebasic.member.domain.Grade;
import gukjin.springlecturebasic.member.domain.Member;
import gukjin.springlecturebasic.member.domain.Order;
import gukjin.springlecturebasic.member.service.MemberService;
import gukjin.springlecturebasic.member.service.MemberServiceImpl;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;


class OrderServiceImplTest {

    private final MemberService memberService = new MemberServiceImpl();
    private final OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(member.getId(), "itemA", 10000);
        assertThat(member).isEqualTo(memberService.findMember(member.getId()));



    }
}