package gukjin.springlecturebasic.member.service;

import gukjin.springlecturebasic.member.domain.Member;

public interface MemberService {
   void join(Member member);
   Member findMember(Long memberId);
}
