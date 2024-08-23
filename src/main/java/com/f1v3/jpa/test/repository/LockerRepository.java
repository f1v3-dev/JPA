package com.f1v3.jpa.test.repository;

import com.f1v3.jpa.test.domain.Locker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LockerRepository extends JpaRepository<Locker, Long> {

}
