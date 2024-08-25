package com.f1v3.jpa.payment;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 결제 엔티티.
 *
 * @author 정승조
 * @version 2024. 08. 23.
 */
@Entity
@Table(name = "payments")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long id;

    @Column(name = "payment_price")
    private Long price;

    @Builder
    public Payment(Long id, Long price) {
        this.id = id;
        this.price = price;
    }
}
