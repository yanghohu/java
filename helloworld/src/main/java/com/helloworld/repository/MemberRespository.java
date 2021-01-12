package com.helloworld.repository;

import com.helloworld.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRespository {
    Member save(Member member);               // 회원저장
    Optional<Member> findById(Long id);       // 회원id로 회원정보 찾기
    Optional<Member> findByName(String name); // 회원이름으로 회원정보 찾기
    List<Member> findAll();                   // 회원정보 전체리스트 조회
}
