package com.woorinpang.settlementservice.domain.company.settlement.temp.domain.history.domain;

import com.woorinpang.settlementservice.domain.company.settlement.common.domain.CompanyId;
import com.woorinpang.settlementservice.domain.company.settlement.common.domain.CompanyPaymentAmount;
import com.woorinpang.settlementservice.domain.company.settlement.common.domain.CompanySettlementDateYmd;
import com.woorinpang.settlementservice.domain.company.settlement.temp.domain.CompanyTempSettlement;
import com.woorinpang.settlementservice.domain.company.settlement.temp.domain.CompanyTempSettlementApply;
import com.woorinpang.settlementservice.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyTempSettlementHistory extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_temp_settlement_history_id") @Comment("회사 임시정산 기록 고유번호")
    private Long id;

    @Embedded
    private CompanyId companyId;

    @Embedded
    private CompanySettlementDateYmd companySettlementDateYmd;

    @Embedded
    private CompanyPaymentAmount companyPaymentAmount;

    @Embedded
    private CompanyTempSettlementApply companyTempSettlementApply;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_temp_settlement_id", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private CompanyTempSettlement companyTempSettlement;

    @Builder(builderMethodName = "createCompanyTempSettlementHistory")
    public CompanyTempSettlementHistory(CompanyTempSettlement companyTempSettlement,
                                        CompanyId companyId,
                                        CompanySettlementDateYmd companySettlementDateYmd,
                                        CompanyPaymentAmount companyPaymentAmount,
                                        CompanyTempSettlementApply companyTempSettlementApply) {
        this.companyTempSettlement = companyTempSettlement;
        this.companyId = companyId;
        this.companySettlementDateYmd = companySettlementDateYmd;
        this.companyPaymentAmount = companyPaymentAmount;
        this.companyTempSettlementApply = companyTempSettlementApply;
    }
}
