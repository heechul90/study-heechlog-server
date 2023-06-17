package com.woorinpang.settlementservice.domain.payment.record.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PaymentRecord {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_record_id")
    private Long id;

    private String transactionId;

    @Embedded
    private User user;

    @Embedded
    private Company company;

    @Embedded
    private Store store;

    @Embedded
    private PaymentAmount paymentAmount;

    private LocalDateTime paymentDate;
    private String paymentDateYmd;
}
