package com.woorinpang.settlementservice.storage.main.db.entity.payment.record.original;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

/**
 * 결제 원본기록
 */
@Entity
@Table(name = "payment_original_record")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PaymentOriginalRecordEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_original_record_id") @Comment("결제 원본기록 고유번호")
    private Long id;

    @Column(columnDefinition = "varchar(36) not null comment '거래 아이디'")
    private String transactionId;

    @Column(columnDefinition = "bigint not null comment '컴퍼니 고유번호'")
    private Long companyId;

    @Column(columnDefinition = "varchar(120) not null comment '컴퍼니명'")
    private String companyName;

    @Column(columnDefinition = "bigint not null comment '스토어 고유번호'")
    private Long storeId;

    @Column(columnDefinition = "varchar(120) not null comment '스토어명'")
    private String storeName;

    @Column(columnDefinition = "bigint not null comment '사용자 고유번호'")
    private Long userId;

    @Column(columnDefinition = "varchar(60) not null comment '사용자 이름'")
    private String userName;

    @Embedded
    private PaymentAmount paymentAmount;

    @Embedded
    private Payment payment;

    @Embedded
    private PaymentCancellation paymentCancellation;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @Builder(builderMethodName = "create")
    public PaymentOriginalRecordEntity(String transactionId, Company company, Store store, User user, PaymentAmount paymentAmount,
                                       Payment payment, PaymentCancellation paymentCancellation, PaymentType paymentType) {
        this.transactionId = transactionId;
        this.companyId = company.getCompanyId();
        this.companyName = company.getCompanyName();
        this.storeId = store.getStoreId();
        this.storeName = store.getStoreName();
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.paymentAmount = paymentAmount;
        this.payment = payment;
        this.paymentCancellation = paymentCancellation;
        this.paymentType = paymentType;
    }
}
