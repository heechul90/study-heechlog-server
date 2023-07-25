package com.woorinpang.settlementservice.domain.bank.domain;

import com.woorinpang.settlementservice.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

/**
 * 은행
 */
@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Bank extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_information_id") @Comment("은행정보 고유번호")
    private Long id;

    @Column(columnDefinition = "varchar(15) not null comment '은행코드'")
    private String bankCode;

    @Column(columnDefinition = "varchar(30) not null comment '은행명'")
    private String bankName;

    @Column(columnDefinition = "bit(1) default true comment '사용여부'")
    private boolean isInUse;
}
