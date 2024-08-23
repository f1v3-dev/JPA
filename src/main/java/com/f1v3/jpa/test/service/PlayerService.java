package com.f1v3.jpa.test.service;

import com.f1v3.jpa.test.domain.Player;
import com.f1v3.jpa.test.domain.PlayerDetail;
import com.f1v3.jpa.test.repository.PlayerDetailRepository;
import com.f1v3.jpa.test.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    private final PlayerDetailRepository playerDetailRepository;

    /**
     * 영속성 전이(CASCADE)를 이용한 INSERT Method.
     */
    @Transactional
    public void createUserWithDetails() {

        Player player = Player.builder()
                .name("player1")
                .createDate(LocalDateTime.now())
                .build();

        Player savedPlayer = playerRepository.save(player);

        PlayerDetail playerDetail1 = new PlayerDetail();
        playerDetail1.setPlayer(player);
        playerDetail1.setPk(new PlayerDetail.Pk(savedPlayer.getPlayerId(), "type1"));
        playerDetail1.setDescription("player1 - type1");


        PlayerDetail playerDetail2 = new PlayerDetail();
        playerDetail2.setPlayer(player);
        playerDetail2.setPk(new PlayerDetail.Pk(savedPlayer.getPlayerId(), "type2"));
        playerDetail2.setDescription("player1 - type2");

        player.getDetails().add(playerDetail1);
        player.getDetails().add(playerDetail2);
    }
}
