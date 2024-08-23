package com.f1v3.jpa.test.repository;

import com.f1v3.jpa.test.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
