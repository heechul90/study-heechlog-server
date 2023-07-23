package com.woorinpang.settlementservice.domain.bank.statement.company.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

/**
 * 컴퍼니 은행 입출금 내역서
 */
@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyBankStatement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_bank_statement_id") @Comment("컴퍼니 은행 입출금 고유번호")
    private Long id;
}
