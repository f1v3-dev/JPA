package com.f1v3.transactional.propagation.repository;

import com.f1v3.transactional.propagation.domain.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<Parent, Long> {
}
