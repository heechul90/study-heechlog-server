package com.woorinpang.settlementservice.domain.company.settlement.apply.domain.history.domain;

import com.woorinpang.settlementservice.domain.company.settlement.apply.domain.CompanySettlementApply;
import com.woorinpang.settlementservice.domain.company.settlement.apply.domain.CompanyApproval;
import com.woorinpang.settlementservice.domain.company.settlement.apply.domain.SettlementApplyAmount;
import com.woorinpang.settlementservice.domain.company.settlement.apply.domain.CompanySettlementType;
import com.woorinpang.settlementservice.domain.company.settlement.common.domain.CompanySettlementDateYmd;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

/**
 * 컴퍼니 정산반영기록
 */
@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanySettlementApplyHistory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_settlement_apply_history_id") @Comment("컴퍼니 정산반영기록 고유번호")
    private Long id;

    @Embedded
    private CompanySettlementDateYmd companySettlementDateYmd;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(15) not null comment '정산 방식'")
    private CompanySettlementType companySettlementType;

    @Embedded
    private SettlementApplyAmount settlementApplyAmount;

    @Embedded
    private CompanyApproval companyApproval;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_apply_settlement_id", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private CompanySettlementApply companySettlementApply;

    @Builder(builderMethodName = "createCompanySettlementApplyHistory")
    public CompanySettlementApplyHistory(CompanySettlementApply companySettlementApply,
                                         CompanySettlementDateYmd companySettlementDateYmd,
                                         CompanySettlementType companySettlementType,
                                         SettlementApplyAmount settlementApplyAmount,
                                         CompanyApproval companyApproval) {
        this.companySettlementApply = companySettlementApply;
        this.companySettlementDateYmd = companySettlementDateYmd;
        this.companySettlementType = companySettlementType;
        this.settlementApplyAmount = settlementApplyAmount;
        this.companyApproval = companyApproval;
    }
}
