package com.f1v3.jpa.test.repository;

import com.f1v3.jpa.test.domain.PlayerDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerDetailRepository extends JpaRepository<PlayerDetail, Long> {

}
