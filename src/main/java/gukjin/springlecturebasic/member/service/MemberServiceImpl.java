package gukjin.springlecturebasic.member.service;

import gukjin.springlecturebasic.member.domain.Member;
import gukjin.springlecturebasic.member.repository.MemberRepository;
import gukjin.springlecturebasic.member.repository.MemoryMemberRepository;

import java.sql.SQLException;
import java.util.Optional;

public class MemberServiceImpl implements MemberService{

    MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) throws IllegalStateException {
        memberRepository.findById(memberId).ifPresentOrElse((e) -> {
            System.out.println(e.getName());
        }, new Runnable() {
            @Override
            public void run() {
                throw new IllegalStateException("중복값입니다");
            }
        });
        return null;
    }
}
