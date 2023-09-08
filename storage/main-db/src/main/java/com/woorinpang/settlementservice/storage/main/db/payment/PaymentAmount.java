package com.woorinpang.settlementservice.storage.main.db.payment;

import com.woorinpang.settlementservice.common.objects.Amount;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
}
