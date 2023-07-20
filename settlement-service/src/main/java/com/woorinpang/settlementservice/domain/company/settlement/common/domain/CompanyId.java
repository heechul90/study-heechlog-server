package com.woorinpang.settlementservice.domain.company.settlement.common.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyId implements Serializable {
    @Column(columnDefinition = "bigint not null comment '회사 고유번호'")
    private Long storeId;

    public CompanyId(Long storeId) {
        this.storeId = storeId;
    }
}
