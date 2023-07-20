package com.woorinpang.settlementservice.domain.company.settlement.common.domain;

import com.woorinpang.settlementservice.global.common.entity.Amount;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanySettlementAmount {
    @Embedded
    @AttributeOverrides(@AttributeOverride(name = "value", column = @Column(name = "mealAmount", columnDefinition = "bigint default 0 comment '식대 결제금액'")))
    private Amount mealAmount;

    @Embedded
    @AttributeOverrides(@AttributeOverride(name = "value",column = @Column(name = "companySettlementAmount", columnDefinition = "bigint default 0 comment '고객사 정산금액'")))
    private Amount companySettlementAmount;
}
