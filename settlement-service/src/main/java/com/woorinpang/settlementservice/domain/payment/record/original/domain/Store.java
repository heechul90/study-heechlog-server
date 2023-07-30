package com.woorinpang.settlementservice.domain.payment.record.original.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 스토어
 */
@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store {
    @Column(columnDefinition = "bigint not null comment '스토어 고유번호'")
    private Long storeId;

    @Column(columnDefinition = "varchar(120) not null comment '스토어명'")
    private String storeName;
}
