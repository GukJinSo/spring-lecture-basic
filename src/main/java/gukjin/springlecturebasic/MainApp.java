package gukjin.springlecturebasic;

import gukjin.springlecturebasic.member.domain.Grade;
import gukjin.springlecturebasic.member.domain.Member;
import gukjin.springlecturebasic.member.service.MemberService;
import gukjin.springlecturebasic.member.service.MemberServiceImpl;

public class MainApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "Spring" ,Grade.VIP);
        memberService.join(member);

        Member memberFind;
        try{
            memberFind = memberService.findMember(2L);
            System.out.println("done");
        }catch(IllegalStateException e){
            System.out.println("Exception occur");
        }
    }
}
