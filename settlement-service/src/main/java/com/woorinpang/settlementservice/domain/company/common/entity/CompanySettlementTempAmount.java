package com.woorinpang.settlementservice.domain.company.common.entity;

import com.woorinpang.settlementservice.global.common.entity.Amount;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 컴퍼니 정산임시금액
 */
@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanySettlementTempAmount {
    @Embedded
    @AttributeOverrides(@AttributeOverride(
            name = "amount",
            column = @Column(name = "paymentAmount", columnDefinition = "decimal(38,2) default 0 comment '결제금액'")))
    private Amount paymentAmount;

    @Embedded
    @AttributeOverrides(@AttributeOverride(
            name = "amount",
            column = @Column(name = "companySettlementAmount", columnDefinition = "decimal(38,2) default 0 comment '컴퍼니 정산금액'")))
    private Amount companySettlementAmount;
}
