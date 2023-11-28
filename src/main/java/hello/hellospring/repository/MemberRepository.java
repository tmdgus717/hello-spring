package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    //멤버 저장
    Member save(Member member);
    //아이디로 찾기
    Optional<Member> findById(Long id);
    //이름으로 찾기
    Optional<Member> findByName(String name);
    //모든 멤버 찾기
    List<Member> findAll();
}
