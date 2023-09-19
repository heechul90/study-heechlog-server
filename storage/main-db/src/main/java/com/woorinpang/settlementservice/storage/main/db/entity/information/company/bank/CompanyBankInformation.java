package com.woorinpang.settlementservice.storage.main.db.entity.information.company.bank;

import com.woorinpang.settlementservice.storage.main.db.entity.bank.bank.Bank;
import com.woorinpang.settlementservice.storage.main.db.entity.information.common.Account;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

/**
 * 컴퍼니 뱅크 정보
 */
@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyBankInformation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_bank_information_id") @Comment("컴퍼니 뱅크 정보 고유번호")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Bank bank;

    @Embedded
    private Account account;
}
