package com.woorinpang.settlementservice.domain.company.settlement.temp.domain.history;

import com.woorinpang.settlementservice.domain.company.common.entity.CompanyId;
import com.woorinpang.settlementservice.domain.company.common.entity.CompanySettlementTempAmount;
import com.woorinpang.settlementservice.domain.company.common.entity.CompanySettlementDateYmd;
import com.woorinpang.settlementservice.domain.company.settlement.temp.domain.CompanySettlementTemp;
import com.woorinpang.settlementservice.domain.company.settlement.temp.domain.CompanySettlementTempApply;
import com.woorinpang.settlementservice.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

/**
 * 컴퍼니 정산임시기록
 */
@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanySettlementTempHistory extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_settlement_temp_history_id") @Comment("컴퍼니 정산임시기록 고유번호")
    private Long id;

    @Embedded
    private CompanyId companyId;

    @Embedded
    private CompanySettlementDateYmd companySettlementDateYmd;

    @Embedded
    private CompanySettlementTempAmount companySettlementTempAmount;

    @Embedded
    private CompanySettlementTempApply companySettlementTempApply;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_settlement_temp_id", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private CompanySettlementTemp companySettlementTemp;

    @Builder(builderMethodName = "createCompanySettlementTempHistory")
    public CompanySettlementTempHistory(CompanySettlementTemp companySettlementTemp,
                                        CompanyId companyId,
                                        CompanySettlementDateYmd companySettlementDateYmd,
                                        CompanySettlementTempAmount companySettlementTempAmount,
                                        CompanySettlementTempApply companySettlementTempApply) {
        this.companySettlementTemp = companySettlementTemp;
        this.companyId = companyId;
        this.companySettlementDateYmd = companySettlementDateYmd;
        this.companySettlementTempAmount = companySettlementTempAmount;
        this.companySettlementTempApply = companySettlementTempApply;
    }
}
