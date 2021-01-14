package com.helloworld.service;

import com.helloworld.domain.Member;
import com.helloworld.repository.MemberRespository;
import com.helloworld.repository.MemoryMemberRespository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRespository memberRespository = new MemoryMemberRespository();

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원X
        validateDuplicateMember(member);

        memberRespository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRespository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findAll() {
        return memberRespository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRespository.findById(memberId);
    }
}
