package gukjin.springlecturebasic.discount;

import gukjin.springlecturebasic.member.domain.Grade;
import gukjin.springlecturebasic.member.domain.Member;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인되어야 한다")
    void discountTest(){
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        int discountedPrice = discountPolicy.discount(member, 10000);
        assertThat(discountedPrice).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP 아닌 경우 할인되면 안된다")
    void discountTestError() {
        Member member = new Member(1L, "memberVIP", Grade.BASIC);
        int discountedPrice = discountPolicy.discount(member, 10000);
        assertThat(discountedPrice).isEqualTo(1000);
    }
}