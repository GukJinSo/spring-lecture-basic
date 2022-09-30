package gukjin.springlecturebasic.discount;

import gukjin.springlecturebasic.member.domain.Grade;
import gukjin.springlecturebasic.member.domain.Member;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        int discountedPrice = member.getGrade() == Grade.VIP ? 1000 : 0;
        return discountedPrice;
    }
}
