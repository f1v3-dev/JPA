package com.f1v3.jpa.payment;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 유저 엔티티.
 *
 * @author 정승조
 * @version 2024. 08. 23.
 */
@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private Long money;

    @Builder
    public User(Long id, Long money) {
        this.id = id;
        this.money = money;
    }
}
