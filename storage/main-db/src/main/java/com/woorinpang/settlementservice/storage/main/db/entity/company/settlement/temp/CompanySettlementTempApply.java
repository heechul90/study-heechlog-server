package com.woorinpang.settlementservice.storage.main.db.entity.company.settlement.temp;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 컴퍼니 정산임시반영
 */
@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanySettlementTempApply {
    @Column(columnDefinition = "bit(1) not null default false comment '반영 여부'")
    private boolean isApplied;

    @Column(columnDefinition = "datetime(6) null comment '반영된 일자'")
    private LocalDateTime appliedDate;

    @Column(columnDefinition = "bigint null comment '반영자 고유번호'")
    private Long applierId;
}
