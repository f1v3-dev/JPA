package com.f1v3.jpa.test.repository;

import com.f1v3.jpa.test.domain.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    // SELECT * FROM Players WHERE name = {name};
    List<Player> findByName(String name);

    // SELECT * FROM Players WHERE name = {name} AND created_at > {created_at};
    List<Player> findByNameAndCreateDateAfter(String name, LocalDateTime createDate);

    // SELECT * FROM Player p
    // INNER JOIN PlayerDetail pd
    // ON p.player_id = pd.player_id
    // WHERE pd.type = {type};
    List<Player> findByDetails_Pk_Type(String type);


    Page<Player> getAllByName(String name, Pageable pageable);

    Slice<Player> readAllByName(String name, Pageable pageable);
}
