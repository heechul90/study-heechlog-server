package com.woorinpang.settlementservice.domain.company.settlement.apply.domain;

import com.woorinpang.settlementservice.global.common.entity.Amount;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SettlementApplyAmount {
    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "amount", column = @Column(name = "mealAmount", columnDefinition = "decimal(38,2) default 0 comment '식대 결제금액'"))
    )
    private Amount mealAmount;

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "amount",column = @Column(name = "serviceAmount", columnDefinition = "decimal(38,2) default 0 comment '서비스 이용금액'"))
    )
    private Amount serviceAmount;

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "amount",column = @Column(name = "companySettlementAmount", columnDefinition = "decimal(38,2) default 0 comment '회사 정산금액'"))
    )
    private Amount companySettlementAmount;
}
