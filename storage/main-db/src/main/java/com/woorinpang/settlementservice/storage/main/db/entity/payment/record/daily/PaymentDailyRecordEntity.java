package com.woorinpang.settlementservice.storage.main.db.entity.payment.record.daily;

import com.woorinpang.settlementservice.common.objects.YearMonthDay;
import com.woorinpang.settlementservice.storage.main.db.entity.company.common.CompanyId;
import com.woorinpang.settlementservice.storage.main.db.entity.payment.record.original.PaymentAmount;
import com.woorinpang.settlementservice.storage.main.db.entity.store.common.StoreId;
import com.woorinpang.settlementservice.storage.main.db.global.entity.BaseEntity;
import com.woorinpang.settlementservice.storage.main.db.global.entity.YearMonthDayConverter;
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
public class PaymentDailyRecordEntity extends BaseEntity {
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
    public PaymentDailyRecordEntity(CompanyId companyId, StoreId storeId, PaymentAmount paymentAmount, YearMonthDay paymentDateYmd) {
        this.companyId = companyId;
        this.storeId = storeId;
        this.paymentAmount = paymentAmount;
        this.paymentDateYmd = paymentDateYmd;
    }
}
