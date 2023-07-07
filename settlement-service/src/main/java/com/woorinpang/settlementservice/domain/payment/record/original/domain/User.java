package com.woorinpang.settlementservice.domain.payment.record.original.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Column(columnDefinition = "bigint not null comment '사용자 고유번호'")
    private Long userId;
    @Column(columnDefinition = "varchar(60) not null comment '사용자 이름'")
    private String userName;
}
