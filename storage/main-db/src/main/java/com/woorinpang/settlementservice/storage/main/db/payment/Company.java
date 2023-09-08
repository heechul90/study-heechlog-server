package com.woorinpang.settlementservice.storage.main.db.payment;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 컴퍼니
 */
@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Company {
    @Column(columnDefinition = "bigint not null comment '컴퍼니 고유번호'")
    private Long companyId;

    @Column(columnDefinition = "varchar(120) not null comment '컴퍼니명'")
    private String companyName;
}
