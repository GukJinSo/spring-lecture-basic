package gukjin.springlecturebasic.order;

import gukjin.springlecturebasic.member.domain.Order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
