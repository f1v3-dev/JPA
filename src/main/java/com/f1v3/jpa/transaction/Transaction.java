package com.f1v3.jpa.transaction;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 거래 엔티티
 *
 * @author 정승조
 * @version 2024. 08. 23.
 */
@Entity
@Table(name = "transactions")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long id;

    @Column(name = "transaction_price")
    private Long price;

    @Builder
    public Transaction(Long id, Long price) {
        this.id = id;
        this.price = price;
    }
}
