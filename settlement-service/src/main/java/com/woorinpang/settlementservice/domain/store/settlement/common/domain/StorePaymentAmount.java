package com.woorinpang.settlementservice.domain.store.settlement.common.domain;

import com.woorinpang.settlementservice.global.common.entity.Amount;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StorePaymentAmount {
    @Embedded
    @AttributeOverrides(@AttributeOverride(name = "amount", column = @Column(
            name = "mealAmount", columnDefinition = "bigint default 0 comment '식대 결제금액'")))
    private Amount mealAmount;

    @Embedded
    @AttributeOverrides(@AttributeOverride(name = "amount",column = @Column(
            name = "storeSettlementAmount", columnDefinition = "bigint default 0 comment '제휴사 정산금액'")))
    private Amount storeSettlementAmount;
}
