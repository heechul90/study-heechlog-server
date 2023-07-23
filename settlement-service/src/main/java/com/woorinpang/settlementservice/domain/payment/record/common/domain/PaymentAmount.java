package com.woorinpang.settlementservice.domain.payment.record.common.domain;

import com.woorinpang.settlementservice.domain.payment.record.original.domain.PaymentOriginalRecord;
import com.woorinpang.settlementservice.global.common.entity.Amount;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PaymentAmount {
    /*@Embedded
    @AttributeOverrides(@AttributeOverride(name = "amount", column = @Column(
            name = "userPayAmount", columnDefinition = "decimal(38,2) default 0 comment '사용자 결제금액'")))
    private Amount userPayAmount;*/

    /*@Embedded
    @AttributeOverrides(@AttributeOverride(name = "amount",column = @Column(
            name = "mypointPayAmount", columnDefinition = "decimal(38,2) default 0 comment '마이포인트 결제금액'")))
    private Amount mypointPayAmount;*/

    /*@Embedded
    @AttributeOverrides(@AttributeOverride(name = "amount",column = @Column(
            name = "instantPayAmount", columnDefinition = "decimal(38,2) default 0 comment '즉시 결제금액'")))
    private Amount instantPayAmount;*/

    @Embedded
    @AttributeOverrides(@AttributeOverride(
            name = "amount",
            column = @Column(name = "mealAmount", columnDefinition = "decimal(38,2) default 0 comment '식대 결제금액'")))
    private Amount mealAmount;

    /*@Embedded
    @AttributeOverrides(@AttributeOverride(name = "amount",column = @Column(
            name = "couponPayAmount", columnDefinition = "decimal(38,2) default 0 comment '쿠폰 결제금액'")))
    private Amount couponAmount;*/

    @Embedded
    @AttributeOverrides(@AttributeOverride(
            name = "amount",
            column = @Column(name = "companySettlementAmount", columnDefinition = "decimal(38,2) default 0 comment '컴퍼니 정산금액'")))
    private Amount companySettlementAmount;

    @Embedded
    @AttributeOverrides(@AttributeOverride(
            name = "amount",
            column = @Column(name = "storeSettlementAmount", columnDefinition = "decimal(38,2) default 0 comment '스토어 정산금액'")))
    private Amount storeSettlementAmount;

    @Builder
    private PaymentAmount(Amount mealAmount, Amount companySettlementAmount, Amount storeSettlementAmount) {
        this.mealAmount = mealAmount;
        this.companySettlementAmount = companySettlementAmount;
        this.storeSettlementAmount = storeSettlementAmount;
    }

    public static PaymentAmount of(Amount mealAmount, Amount companySettlementAmount, Amount storeSettlementAmount) {
        return PaymentAmount.builder()
                .mealAmount(mealAmount)
                .companySettlementAmount(companySettlementAmount)
                .storeSettlementAmount(storeSettlementAmount)
                .build();
    }

    public static PaymentAmount of(List<PaymentOriginalRecord> paymentOriginalRecords) {
        return PaymentAmount.builder()
                .mealAmount(Amount.create(paymentOriginalRecords.stream()
                        .map(paymentOriginalRecord -> paymentOriginalRecord.getPaymentAmount().getMealAmount().getAmount())
                        .reduce(BigDecimal.ZERO, BigDecimal::add)))
                .companySettlementAmount(Amount.create(paymentOriginalRecords.stream()
                        .map(paymentOriginalRecord -> paymentOriginalRecord.getPaymentAmount().getCompanySettlementAmount().getAmount())
                        .reduce(BigDecimal.ZERO, BigDecimal::add)))
                .storeSettlementAmount(Amount.create(paymentOriginalRecords.stream()
                        .map(paymentOriginalRecord -> paymentOriginalRecord.getPaymentAmount().getStoreSettlementAmount().getAmount())
                        .reduce(BigDecimal.ZERO, BigDecimal::add)))
                .build();
    }
}
