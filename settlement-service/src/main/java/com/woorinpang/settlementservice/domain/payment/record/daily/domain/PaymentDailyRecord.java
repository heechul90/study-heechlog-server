package com.woorinpang.settlementservice.domain.payment.record.daily.domain;

import com.woorinpang.settlementservice.domain.payment.record.common.domain.PaymentAmount;
import com.woorinpang.settlementservice.domain.payment.record.original.domain.Company;
import com.woorinpang.settlementservice.domain.payment.record.original.domain.*;
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
public class PaymentDailyRecord extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_daily_record_id") @Comment("결제 일일 기록 고유번호")
    private Long id;

    @Column(columnDefinition = "bigint not null comment '고객사 고유번호'")
    private Long companyId;

    @Column(columnDefinition = "bigint not null comment '제휴사 고유번호'")
    private Long storeId;

    @Embedded
    private PaymentAmount paymentAmount;
}
