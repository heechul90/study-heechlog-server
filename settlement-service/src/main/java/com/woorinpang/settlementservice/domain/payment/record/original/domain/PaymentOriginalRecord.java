package com.woorinpang.settlementservice.domain.payment.record.original.domain;

import com.woorinpang.settlementservice.domain.payment.record.common.domain.PaymentAmount;
import com.woorinpang.settlementservice.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PaymentOriginalRecord extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_original_record_id") @Comment("결제 원본 기록 고유번호")
    private Long id;

    @Column(columnDefinition = "varchar(36) not null comment '거래 고유 아이디'")
    private String transactionId;

    @Embedded
    private Company company;

    @Embedded
    private Store store;

    @Embedded
    private User user;

    @Embedded
    private PaymentAmount paymentAmount;

    @Embedded
    private Payment payment;

    @Embedded
    private PaymentCancellation paymentCancellation;

    private Integer status;
}