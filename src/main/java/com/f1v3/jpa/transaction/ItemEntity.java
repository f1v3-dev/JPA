package com.f1v3.jpa.transaction;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class ItemEntity {

    @Id
    private Long id;

    private String name;

    @Builder
    public ItemEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
