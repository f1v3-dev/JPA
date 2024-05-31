package com.f1v3.jpa;


import com.f1v3.jpa.domain.Locker;
import com.f1v3.jpa.domain.Member;
import com.f1v3.jpa.repository.LockerRepository;
import com.f1v3.jpa.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OneToOneTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    LockerRepository lockerRepository;

    @Test
    @DisplayName("Member Entity 조회")
    void findMember() {

        Member member = Member.builder()
                .userName("seungjo")
                .build();

        memberRepository.save(member);

        System.out.println("================================");
        memberRepository.findById(1L)
                .orElseThrow(() -> new IllegalArgumentException("해당 회원이 존재하지 않습니다."));
        System.out.println("================================");
    }

    @Test
    @DisplayName("Locker Entity 조회 -> N+1 문제 발생")
    void findLocker() {

        Locker locker = Locker.builder()
                .name("red locker")
                .build();

        lockerRepository.save(locker);

        System.out.println("================================");
        lockerRepository.findById(1L)
                .orElseThrow(() -> new IllegalArgumentException("해당 락커가 존재하지 않습니다."));
        System.out.println("================================");

    }
}
