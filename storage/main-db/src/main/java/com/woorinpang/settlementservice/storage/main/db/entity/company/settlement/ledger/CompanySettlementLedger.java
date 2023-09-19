package com.woorinpang.settlementservice.storage.main.db.entity.company.settlement.ledger;

import com.woorinpang.settlementservice.storage.main.db.entity.company.common.CompanyId;
import com.woorinpang.settlementservice.storage.main.db.entity.company.common.CompanySettlementDateYmd;
import com.woorinpang.settlementservice.storage.main.db.entity.company.settlement.apply.CompanySettlementType;
import com.woorinpang.settlementservice.storage.main.db.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

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
