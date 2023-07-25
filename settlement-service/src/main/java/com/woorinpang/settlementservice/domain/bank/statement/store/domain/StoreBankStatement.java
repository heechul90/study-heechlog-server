package com.woorinpang.settlementservice.domain.bank.statement.store.domain;

import com.woorinpang.settlementservice.domain.bank.statement.common.entity.TransactionType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

/**
 * 스토어 은행 입출금 내역서
 */
@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StoreBankStatement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_bank_statement_id") @Comment("스토어 은행 입출금 고유번호")
    private Long id;

    @Column(columnDefinition = "varchar(15) not null comment '거래유형'")
    private TransactionType transactionType;
}
