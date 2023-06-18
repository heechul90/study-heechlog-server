package com.woorinpang.settlementservice.domain.payment.settlement.domain;

import com.woorinpang.settlementservice.domain.payment.record.domain.PaymentAmount;
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
public class PaymentDailySettlement extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_daily_settlement_id") @Comment("결제 일일정산 고유번호")
    private Long id;

    @Column(columnDefinition = "bigint not null comment '고객사 고유번호'")
    private Long companyId;

    @Column(columnDefinition = "bigint not null comment '제휴사 고유번호'")
    private Long storeId;

    @Embedded
    private PaymentAmount paymentAmount;

    @Column(columnDefinition = "char(8) not null comment '정산 년월일'")
    @Convert(converter = YearMonthDayConverter.class)
    private YearMonthDay settlementYmd;

}
