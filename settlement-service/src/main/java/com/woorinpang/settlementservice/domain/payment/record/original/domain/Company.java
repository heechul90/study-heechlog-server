package com.woorinpang.settlementservice.domain.payment.record.original.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Company {
    @Column(columnDefinition = "bigint not null comment '고객사 고유번호'")
    private Long companyId;

    @Column(columnDefinition = "varchar(120) not null comment '고객사명'")
    private String companyName;
}
