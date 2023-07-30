package com.woorinpang.settlementservice.domain.payment.common.entity;

import com.woorinpang.settlementservice.domain.payment.record.original.domain.PaymentOriginalRecord;
import com.woorinpang.settlementservice.global.common.entity.Amount;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * 결제 금액
 */
@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PaymentAmount {
    @Embedded
    @AttributeOverrides(@AttributeOverride(
            name = "amount",
            column = @Column(name = "payment_amount", columnDefinition = "decimal(38,2) default 0 comment '결제금액'")))
    private Amount paymentAmount;

    @Embedded
    @AttributeOverrides(@AttributeOverride(
            name = "amount",
            column = @Column(name = "company_settlement_amount", columnDefinition = "decimal(38,2) default 0 comment '컴퍼니 정산금액'")))
    private Amount companySettlementAmount;

    @Embedded
    @AttributeOverrides(@AttributeOverride(
            name = "amount",
            column = @Column(name = "store_settlement_amount", columnDefinition = "decimal(38,2) default 0 comment '스토어 정산금액'")))
    private Amount storeSettlementAmount;

    @Builder
    private PaymentAmount(Amount paymentAmount, Amount companySettlementAmount, Amount storeSettlementAmount) {
        this.paymentAmount = paymentAmount;
        this.companySettlementAmount = companySettlementAmount;
        this.storeSettlementAmount = storeSettlementAmount;
    }

    public static PaymentAmount of(Amount paymentAmount, Amount companySettlementAmount, Amount storeSettlementAmount) {
        return PaymentAmount.builder()
                .paymentAmount(paymentAmount)
                .companySettlementAmount(companySettlementAmount)
                .storeSettlementAmount(storeSettlementAmount)
                .build();
    }

    public static PaymentAmount of(List<PaymentOriginalRecord> paymentOriginalRecords) {
        return PaymentAmount.builder()
                .paymentAmount(Amount.create(paymentOriginalRecords.stream()
                        .map(paymentOriginalRecord -> paymentOriginalRecord.getPaymentAmount().getPaymentAmount().getAmount())
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
