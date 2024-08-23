package com.f1v3.jpa.test.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private Long playerId;

    private String name;

    @Column(name = "created_at")
    private LocalDateTime createDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "player")
    private List<PlayerDetail> details = new ArrayList<>();
    
    @Builder
    public Player(String name, LocalDateTime createDate) {
        this.name = name;
        this.createDate = createDate;
    }
}
