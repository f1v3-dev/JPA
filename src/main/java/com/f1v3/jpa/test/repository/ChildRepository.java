package com.f1v3.jpa.test.repository;


import com.f1v3.jpa.test.domain.Child;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<Child, Long> {

}
