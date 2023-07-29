package com.woorinpang.settlementservice.domain.information.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account {
    @Column(columnDefinition = "varchar(30) not null comment '예금주'")
    private String accountHolder;

    @Column(columnDefinition = "varchar(30) not null comment '계좌번호'")
    private String accountNumber;
}
