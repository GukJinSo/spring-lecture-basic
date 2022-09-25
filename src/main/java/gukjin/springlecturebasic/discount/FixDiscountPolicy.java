package gukjin.springlecturebasic.discount;

import gukjin.springlecturebasic.member.domain.Grade;
import gukjin.springlecturebasic.member.domain.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        int discountedPrice = member.getGrade() == Grade.VIP ? price - 1000 : 0;
        return discountedPrice;
    }
}
