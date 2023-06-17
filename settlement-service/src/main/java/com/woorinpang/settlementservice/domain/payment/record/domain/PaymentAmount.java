package com.woorinpang.settlementservice.domain.payment.record.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PaymentAmount {
    @Embedded
    @AttributeOverrides(@AttributeOverride(name = "value", column = @Column(name = "priceAmount")))
    private Amount priceAmount;

    @Embedded
    @AttributeOverrides(@AttributeOverride(name = "value", column = @Column(name = "mypointAmount")))
    private Amount mypointAmount;

    @Embedded
    @AttributeOverrides(@AttributeOverride(name = "value", column = @Column(name = "instantAmount")))
    private Amount instantAmount;

    @Embedded
    @AttributeOverrides(@AttributeOverride(name = "value", column = @Column(name = "mealAmount")))
    private Amount mealAmount;

    @Embedded
    @AttributeOverrides(@AttributeOverride(name = "value", column = @Column(name = "companySettlementAmount")))
    private Amount companySettlementAmount;

    @Embedded
    @AttributeOverrides(@AttributeOverride(name = "value", column = @Column(name = "storeSettlementAmount")))
    private Amount storeSettlementAmount;

    @Embedded
    @AttributeOverrides(@AttributeOverride(name = "value", column = @Column(name = "couponAmount")))
    private Amount couponAmount;
}
