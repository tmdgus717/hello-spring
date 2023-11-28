package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    //생성자 주입
    public MemberService(MemberRepository memberRepository) {
        //DI(의존성 주입 : test = 외부에서 new로 생성해서 주입)
        this.memberRepository = memberRepository;
    }
    //서비스영역에서는 비즈니스 로직이 들어간다.

    //회원가입
    //로직 :: 이미 가입한 회원이 있는지 확인하고 repository.save();
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    //전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
