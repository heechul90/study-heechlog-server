package com.woorinpang.domain.payment.domain;

import jakarta.persistence.*;

@Entity
public class PaymentRecord {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_record_id")
    private Long id;
}
