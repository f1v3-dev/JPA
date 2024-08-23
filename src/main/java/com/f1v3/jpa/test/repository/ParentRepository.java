package com.f1v3.jpa.test.repository;

import com.f1v3.jpa.test.domain.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<Parent, Long> {
}
