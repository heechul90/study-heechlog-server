package com.woorinpang.settlementservice.domain.company.common.entity;

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
    @Column(columnDefinition = "bigint not null comment '컴퍼니 고유번호'")
    private Long companyId;

    public CompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
