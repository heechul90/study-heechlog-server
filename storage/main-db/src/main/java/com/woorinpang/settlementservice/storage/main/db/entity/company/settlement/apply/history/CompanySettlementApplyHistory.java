package com.woorinpang.settlementservice.storage.main.db.entity.company.settlement.apply.history;

import com.woorinpang.settlementservice.storage.main.db.entity.company.common.CompanySettlementDateYmd;
import com.woorinpang.settlementservice.storage.main.db.entity.company.settlement.apply.CompanyApproval;
import com.woorinpang.settlementservice.storage.main.db.entity.company.settlement.apply.CompanySettlementApply;
import com.woorinpang.settlementservice.storage.main.db.entity.company.settlement.apply.CompanySettlementApplyAmount;
import com.woorinpang.settlementservice.storage.main.db.entity.company.settlement.apply.CompanySettlementType;
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
    private CompanySettlementApplyAmount settlementApplyAmount;

    @Embedded
    private CompanyApproval companyApproval;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_apply_settlement_id", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private CompanySettlementApply companySettlementApply;

    @Builder(builderMethodName = "createCompanySettlementApplyHistory")
    public CompanySettlementApplyHistory(CompanySettlementApply companySettlementApply,
                                         CompanySettlementDateYmd companySettlementDateYmd,
                                         CompanySettlementType companySettlementType,
                                         CompanySettlementApplyAmount settlementApplyAmount,
                                         CompanyApproval companyApproval) {
        this.companySettlementApply = companySettlementApply;
        this.companySettlementDateYmd = companySettlementDateYmd;
        this.companySettlementType = companySettlementType;
        this.settlementApplyAmount = settlementApplyAmount;
        this.companyApproval = companyApproval;
    }
}
