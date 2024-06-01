package com.f1v3.jpa.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * N:1 단방향 연관관계 매핑
 * Player -> PlayerDetail
 */
@Setter
@Entity
public class PlayerDetail {

    @EmbeddedId
    private Pk pk;

    private String description;

    @ManyToOne
    @MapsId("playerId")
    private Player player;

    @Embeddable
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class Pk implements Serializable {
        @Column(name = "player_id")
        private Long playerId;

        private String type;
    }
}
