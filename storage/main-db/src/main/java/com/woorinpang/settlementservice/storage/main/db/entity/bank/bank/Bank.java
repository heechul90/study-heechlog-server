package com.woorinpang.settlementservice.storage.main.db.entity.bank.bank;

import com.woorinpang.settlementservice.storage.main.db.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

/**
 * 뱅크
 */
@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Bank extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_id") @Comment("뱅크 고유번호")
    private Long id;

    @Column(columnDefinition = "varchar(15) not null comment '뱅크코드'")
    private String bankCode;

    @Column(columnDefinition = "varchar(30) not null comment '뱅크명'")
    private String bankName;

    @Column(columnDefinition = "bit(1) default true comment '사용여부'")
    private boolean isInUse;
}
