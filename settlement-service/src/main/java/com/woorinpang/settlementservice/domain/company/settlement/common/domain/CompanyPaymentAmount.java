package com.woorinpang.settlementservice.domain.company.settlement.common.domain;

import com.woorinpang.settlementservice.global.common.entity.Amount;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyPaymentAmount {
    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "amount", column = @Column(name = "mealAmount", columnDefinition = "decimal(38,2) default 0 comment '식대 결제금액'"))
    )
    private Amount mealAmount;

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "amount",column = @Column(name = "companySettlementAmount", columnDefinition = "decimal(38,2) default 0 comment '고객사 정산금액'"))
    )
    private Amount companySettlementAmount;
}
