package com.woorinpang.settlementservice.storage.main.db.entity.payment.record.original;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 사용자
 */
@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User {
    @Column(columnDefinition = "bigint not null comment '사용자 고유번호'")
    private Long userId;
    @Column(columnDefinition = "varchar(60) not null comment '사용자 이름'")
    private String userName;
}
