package com.woorinpang.settlementservice.domain.company.settlement.apply.domain.history.domain;

import com.woorinpang.settlementservice.domain.company.settlement.apply.domain.CompanyApplySettlement;
import com.woorinpang.settlementservice.domain.company.settlement.apply.domain.CompanyApproval;
import com.woorinpang.settlementservice.domain.company.settlement.apply.domain.CompanySettlementAmount;
import com.woorinpang.settlementservice.domain.company.settlement.apply.domain.CompanySettlementType;
import com.woorinpang.settlementservice.domain.company.settlement.common.domain.CompanySettlementDateYmd;
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
public class CompanyApplySettlementHistory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_apply_settlement_history_id") @Comment("회사 적용정산기록 고유번호")
    private Long id;

    @Embedded
    private CompanySettlementDateYmd companySettlementDateYmd;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(15) not null comment '정산 방식'")
    private CompanySettlementType companySettlementType;

    @Embedded
    private CompanySettlementAmount companySettlementAmount;

    @Embedded
    private CompanyApproval companyApproval;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_apply_settlement_id", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private CompanyApplySettlement companyApplySettlement;

    @Builder(builderMethodName = "createCompanyApplySettlementHistory")
    public CompanyApplySettlementHistory(CompanyApplySettlement companyApplySettlement,
                                         CompanySettlementDateYmd companySettlementDateYmd,
                                         CompanySettlementType companySettlementType,
                                         CompanySettlementAmount companySettlementAmount,
                                         CompanyApproval companyApproval) {
        this.companyApplySettlement = companyApplySettlement;
        this.companySettlementDateYmd = companySettlementDateYmd;
        this.companySettlementType = companySettlementType;
        this.companySettlementAmount = companySettlementAmount;
        this.companyApproval = companyApproval;
    }
}
