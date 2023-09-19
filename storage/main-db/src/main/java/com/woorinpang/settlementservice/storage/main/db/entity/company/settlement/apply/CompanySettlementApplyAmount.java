package com.woorinpang.settlementservice.storage.main.db.entity.company.settlement.apply;

import com.woorinpang.settlementservice.common.objects.Amount;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanySettlementApplyAmount {
    @Embedded
    @AttributeOverrides(@AttributeOverride(
            name = "amount",
            column = @Column(name = "paymentAmount", columnDefinition = "decimal(38,2) default 0 comment '결제금액'"))
    )
    private Amount paymentAmount;

    @Embedded
    @AttributeOverrides(@AttributeOverride(
            name = "amount",
            column = @Column(name = "serviceAmount", columnDefinition = "decimal(38,2) default 0 comment '서비스 이용금액'"))
    )
    private Amount serviceAmount;

    @Embedded
    @AttributeOverrides(@AttributeOverride(
            name = "amount",
            column = @Column(name = "companySettlementAmount", columnDefinition = "decimal(38,2) default 0 comment '컴퍼니 정산금액'"))
    )
    private Amount companySettlementAmount;
}
