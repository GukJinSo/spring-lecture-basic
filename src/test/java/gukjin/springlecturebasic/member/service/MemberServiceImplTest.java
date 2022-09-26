package gukjin.springlecturebasic.member.service;

import gukjin.springlecturebasic.config.AppConfig;
import gukjin.springlecturebasic.member.domain.Grade;
import gukjin.springlecturebasic.member.domain.Member;
import gukjin.springlecturebasic.member.repository.MemberRepository;
import gukjin.springlecturebasic.member.repository.MemoryMemberRepository;
import gukjin.springlecturebasic.order.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

class MemberServiceImplTest {

    MemberService memberService;

    @BeforeEach
    void beforeEach(){
        memberService = new AppConfig().memberService();

    }
    @Test
    void join(){

        //given
        Member member = new Member(1L, "Spring" , Grade.VIP);
        memberService.join(member);

        //when
        Member findMember = memberService.findMember(1L);

        //then
        assertThat(findMember).isEqualTo(member);
    }


}