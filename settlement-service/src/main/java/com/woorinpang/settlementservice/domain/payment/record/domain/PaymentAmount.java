package com.woorinpang.settlementservice.domain.payment.record.domain;

import com.woorinpang.settlementservice.global.common.entity.Amount;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PaymentAmount {
    @Embedded
    @AttributeOverrides(@AttributeOverride(name = "value",column = @Column(name = "userPayAmount", columnDefinition = "bigint default 0 comment '사용자 결제금액'")))
    private Amount userPayAmount;

    @Embedded
    @AttributeOverrides(@AttributeOverride(name = "value",column = @Column(name = "mypointPayAmount", columnDefinition = "bigint default 0 comment '마이포인트 결제금액'")))
    private Amount mypointPayAmount;

    @Embedded
    @AttributeOverrides(@AttributeOverride(name = "value",column = @Column(name = "instantPayAmount", columnDefinition = "bigint default 0 comment '즉시 결제금액'")))
    private Amount instantPayAmount;

    @Embedded
    @AttributeOverrides(@AttributeOverride(name = "value", column = @Column(name = "mealAmount", columnDefinition = "bigint default 0 comment '식대 결제금액'")))
    private Amount mealAmount;

    @Embedded
    @AttributeOverrides(@AttributeOverride(name = "value",column = @Column(name = "companySettlementAmount", columnDefinition = "bigint default 0 comment '고객사 정산금액'")))
    private Amount companySettlementAmount;

    @Embedded
    @AttributeOverrides(@AttributeOverride(name = "value",column = @Column(name = "storeSettlementAmount", columnDefinition = "bigint default 0 comment '제휴사 정산금액'")))
    private Amount storeSettlementAmount;

    @Embedded
    @AttributeOverrides(@AttributeOverride(name = "value",column = @Column(name = "couponPayAmount", columnDefinition = "bigint default 0 comment '쿠폰 결재금액'")))
    private Amount couponAmount;
}
