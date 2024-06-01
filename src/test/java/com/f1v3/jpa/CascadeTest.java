package com.f1v3.jpa;

import com.f1v3.jpa.service.PlayerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CascadeTest {

    @Autowired
    PlayerService playerService;

    @Test
    @DisplayName("영속성 전이를 통한 insert 테스트")
    void createUserWithDetailsTest() {

        // N:1 단방향 연관관계 매핑에서는 정상적으로 동작!
        playerService.createUserWithDetails();

    }
}
