package com.woorinpang.settlementservice.domain.company.settlement.temp.domain;

import com.woorinpang.settlementservice.domain.company.settlement.common.domain.CompanyId;
import com.woorinpang.settlementservice.domain.company.settlement.common.domain.CompanyPaymentAmount;
import com.woorinpang.settlementservice.domain.company.settlement.common.domain.CompanySettlementDateYmd;
import com.woorinpang.settlementservice.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyTempSettlement extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_temp_settlement_id") @Comment("회사 임시정산 고유번호")
    private Long id;

    @Embedded
    private CompanyId companyId;

    @Embedded
    private CompanySettlementDateYmd companySettlementDateYmd;

    @Embedded
    private CompanyPaymentAmount companyPaymentAmount;

    @Embedded
    private CompanyTempSettlementApply companyTempSettlementApply;
}
