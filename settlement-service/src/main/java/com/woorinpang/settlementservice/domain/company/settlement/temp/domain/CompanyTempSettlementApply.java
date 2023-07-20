package com.woorinpang.settlementservice.domain.company.settlement.temp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyTempSettlementApply {
    @Column(columnDefinition = "bit(1) not null default false comment '반영 여부'")
    private boolean isApplied;

    @Column(columnDefinition = "datetime(6) null comment '반영 일자'")
    private LocalDateTime appliedDate;
}
