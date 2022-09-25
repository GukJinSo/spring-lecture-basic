package gukjin.springlecturebasic.member.service;

import gukjin.springlecturebasic.member.domain.Member;
import gukjin.springlecturebasic.member.repository.MemberRepository;
import gukjin.springlecturebasic.member.repository.MemoryMemberRepository;

import javax.swing.text.html.Option;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.Optional;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) throws NoSuchElementException {
        return memberRepository.findById(memberId);
    }
}
