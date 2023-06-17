package com.woorinpang.settlementservice.domain.payment.record.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Company {
    @Column
    private Long companyId;

    @Column
    private String companyName;
}
