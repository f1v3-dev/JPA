package com.f1v3.jpa.repository;

import com.f1v3.jpa.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
