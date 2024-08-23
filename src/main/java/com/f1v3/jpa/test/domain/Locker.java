package com.f1v3.jpa.test.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Locker {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "locker")
    private Member member;

    @Builder
    public Locker(String name, Member member) {
        this.name = name;
        this.member = member;
    }
}
