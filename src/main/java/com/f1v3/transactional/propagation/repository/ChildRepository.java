package com.f1v3.transactional.propagation.repository;


import com.f1v3.transactional.propagation.domain.Child;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<Child, Long> {

}