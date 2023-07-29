package com.woorinpang.settlementservice.domain.bank.statement.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

/**
 * 뱅크 입출금내역
 */
@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BankStatement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_statement_id") @Comment("뱅크 임출금내역 고유번호")
    private Long id;
}
