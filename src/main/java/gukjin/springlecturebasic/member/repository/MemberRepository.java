package gukjin.springlecturebasic.member.repository;

import gukjin.springlecturebasic.member.domain.Member;

import java.util.Optional;

public interface MemberRepository {
    void save(Member member);
    Optional<Member> findById(Long memberId);
}
