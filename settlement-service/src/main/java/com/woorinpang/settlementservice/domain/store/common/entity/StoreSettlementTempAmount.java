package com.woorinpang.settlementservice.domain.store.common.entity;

import com.woorinpang.settlementservice.global.common.entity.Amount;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 스토어 정산임시금액
 */
@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StoreSettlementTempAmount {
    @Embedded
    @AttributeOverrides(@AttributeOverride(
            name = "amount",
            column = @Column(name = "paymentAmount", columnDefinition = "decimal(38,2) default 0 comment '결제금액'")))
    private Amount paymentAmount;

    @Embedded
    @AttributeOverrides(@AttributeOverride(
            name = "amount",
            column = @Column(name = "storeSettlementAmount", columnDefinition = "decimal(38,2) default 0 comment '스토어 정산금액'")))
    private Amount storeSettlementAmount;
}
