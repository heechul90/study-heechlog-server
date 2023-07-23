package com.woorinpang.settlementservice.domain.payment.record.daily.domain;

import com.woorinpang.settlementservice.domain.company.settlement.common.domain.CompanyId;
import com.woorinpang.settlementservice.domain.payment.record.common.domain.PaymentAmount;
import com.woorinpang.settlementservice.domain.store.settlement.common.domain.StoreId;
import com.woorinpang.settlementservice.global.common.entity.BaseEntity;
import com.woorinpang.settlementservice.global.common.entity.YearMonthDay;
import com.woorinpang.settlementservice.global.common.entity.YearMonthDayConverter;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

/**
 * 결제 일일기록
 */
@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PaymentDailyRecord extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_daily_record_id") @Comment("결제 일일기록 고유번호")
    private Long id;

    @Embedded
    private CompanyId companyId;

    @Embedded
    private StoreId storeId;

    @Embedded
    private PaymentAmount paymentAmount;

    @Column(columnDefinition = "char(8) not null comment '결제일자 년월일'")
    @Convert(converter = YearMonthDayConverter.class)
    private YearMonthDay paymentDateYmd;

    @Builder(builderMethodName = "createPaymentDailyRecord")
    public PaymentDailyRecord(CompanyId companyId, StoreId storeId, PaymentAmount paymentAmount, YearMonthDay paymentDateYmd) {
        this.companyId = companyId;
        this.storeId = storeId;
        this.paymentAmount = paymentAmount;
        this.paymentDateYmd = paymentDateYmd;
    }
}
