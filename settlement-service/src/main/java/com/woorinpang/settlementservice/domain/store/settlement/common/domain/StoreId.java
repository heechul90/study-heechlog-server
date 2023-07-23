package com.woorinpang.settlementservice.domain.store.settlement.common.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StoreId implements Serializable {
    @Column(columnDefinition = "bigint not null comment '스토어 고유번호'")
    private Long storeId;

    public StoreId(Long storeId) {
        this.storeId = storeId;
    }
}
