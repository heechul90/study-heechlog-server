package com.woorinpang.settlementservice.domain.company.settlement.ledger.domain;

import com.woorinpang.settlementservice.domain.company.settlement.apply.domain.CompanySettlementType;
import com.woorinpang.settlementservice.domain.company.settlement.common.domain.CompanyId;
import com.woorinpang.settlementservice.domain.company.settlement.common.domain.CompanySettlementDateYmd;
import com.woorinpang.settlementservice.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.util.Date;

/**
 * 컴퍼니 정산원장
 */
@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanySettlementLedger extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_settlement_ledger_id") @Comment("컴퍼니 정산원장 고유번호")
    private Long id;

    @Embedded
    private CompanyId companyId;

    @Enumerated(EnumType.STRING)
    private CompanySettlementType companySettlementType;

    @Embedded
    private CompanySettlementDateYmd companySettlementDateYmd;

    @Embedded
    private CompanySettlementLedgerAmount companySettlementLedgerAmount;

    @Embedded
    private CompanyBankInformation companyBankInformation;
}
