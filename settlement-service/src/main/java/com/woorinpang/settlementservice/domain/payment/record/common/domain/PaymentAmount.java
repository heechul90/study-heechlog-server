package com.woorinpang.settlementservice.domain.payment.record.common.domain;

import com.woorinpang.settlementservice.domain.payment.record.original.domain.PaymentOriginalRecord;
import com.woorinpang.settlementservice.global.common.entity.Amount;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PaymentAmount {
    @Embedded
    @AttributeOverrides(@AttributeOverride(name = "value", column = @Column(
            name = "userPayAmount", columnDefinition = "bigint default 0 comment '사용자 결제금액'")))
    private Amount userPayAmount;

    @Embedded
    @AttributeOverrides(@AttributeOverride(name = "value",column = @Column(
            name = "mypointPayAmount", columnDefinition = "bigint default 0 comment '마이포인트 결제금액'")))
    private Amount mypointPayAmount;

    @Embedded
    @AttributeOverrides(@AttributeOverride(name = "value",column = @Column(
            name = "instantPayAmount", columnDefinition = "bigint default 0 comment '즉시 결제금액'")))
    private Amount instantPayAmount;

    @Embedded
    @AttributeOverrides(@AttributeOverride(name = "value", column = @Column(
            name = "mealAmount", columnDefinition = "bigint default 0 comment '식대 결제금액'")))
    private Amount mealAmount;

    @Embedded
    @AttributeOverrides(@AttributeOverride(name = "value",column = @Column(
            name = "couponPayAmount", columnDefinition = "bigint default 0 comment '쿠폰 결제금액'")))
    private Amount couponAmount;

    @Embedded
    @AttributeOverrides(@AttributeOverride(name = "value",column = @Column(
            name = "companySettlementAmount", columnDefinition = "bigint default 0 comment '고객사 정산금액'")))
    private Amount companySettlementAmount;

    @Embedded
    @AttributeOverrides(@AttributeOverride(name = "value",column = @Column(
            name = "storeSettlementAmount", columnDefinition = "bigint default 0 comment '제휴사 정산금액'")))
    private Amount storeSettlementAmount;

    @Builder
    private PaymentAmount(Amount userPayAmount, Amount mypointPayAmount, Amount instantPayAmount, Amount mealAmount,
                         Amount couponAmount, Amount companySettlementAmount, Amount storeSettlementAmount) {
        this.userPayAmount = userPayAmount;
        this.mypointPayAmount = mypointPayAmount;
        this.instantPayAmount = instantPayAmount;
        this.mealAmount = mealAmount;
        this.couponAmount = couponAmount;
        this.companySettlementAmount = companySettlementAmount;
        this.storeSettlementAmount = storeSettlementAmount;
    }

    public static PaymentAmount of(Amount userPayAmount, Amount mypointPayAmount, Amount instantPayAmount, Amount mealAmount,
                                   Amount couponAmount, Amount companySettlementAmount, Amount storeSettlementAmount) {
        return PaymentAmount.builder()
                .userPayAmount(userPayAmount)
                .mypointPayAmount(mypointPayAmount)
                .instantPayAmount(instantPayAmount)
                .mealAmount(mealAmount)
                .couponAmount(couponAmount)
                .companySettlementAmount(companySettlementAmount)
                .storeSettlementAmount(storeSettlementAmount)
                .build();
    }

    public static PaymentAmount of(List<PaymentOriginalRecord> paymentOriginalRecords) {
        return PaymentAmount.builder()
                .userPayAmount(Amount.create(paymentOriginalRecords.stream()
                        .mapToLong(paymentOriginalRecord -> paymentOriginalRecord.getPaymentAmount().getUserPayAmount().getValue())
                        .sum()))
                .mypointPayAmount(Amount.create(paymentOriginalRecords.stream()
                        .mapToLong(paymentOriginalRecord -> paymentOriginalRecord.getPaymentAmount().getMypointPayAmount().getValue())
                        .sum()))
                .instantPayAmount(Amount.create(paymentOriginalRecords.stream()
                        .mapToLong(paymentOriginalRecord -> paymentOriginalRecord.getPaymentAmount().getInstantPayAmount().getValue())
                        .sum()))
                .mealAmount(Amount.create(paymentOriginalRecords.stream()
                        .mapToLong(paymentOriginalRecord -> paymentOriginalRecord.getPaymentAmount().getMealAmount().getValue())
                        .sum()))
                .couponAmount(Amount.create(paymentOriginalRecords.stream()
                        .mapToLong(paymentOriginalRecord -> paymentOriginalRecord.getPaymentAmount().getCouponAmount().getValue())
                        .sum()))
                .companySettlementAmount(Amount.create(paymentOriginalRecords.stream()
                        .mapToLong(paymentOriginalRecord -> paymentOriginalRecord.getPaymentAmount().getCompanySettlementAmount().getValue())
                        .sum()))
                .storeSettlementAmount(Amount.create(paymentOriginalRecords.stream()
                        .mapToLong(paymentOriginalRecord -> paymentOriginalRecord.getPaymentAmount().getStoreSettlementAmount().getValue())
                        .sum()))
                .build();
    }
}
