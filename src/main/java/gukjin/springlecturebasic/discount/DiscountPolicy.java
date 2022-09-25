package gukjin.springlecturebasic.discount;

import gukjin.springlecturebasic.member.domain.Member;

public interface DiscountPolicy {

    public int discount(Member member, int price);
}
