package com.woorinpang.settlementservice.storage.main.db.entity.company.settlement.temp.history;

import com.woorinpang.settlementservice.storage.main.db.entity.company.common.CompanyId;
import com.woorinpang.settlementservice.storage.main.db.entity.company.common.CompanySettlementDateYmd;
import com.woorinpang.settlementservice.storage.main.db.entity.company.common.CompanySettlementTempAmount;
import com.woorinpang.settlementservice.storage.main.db.entity.company.settlement.temp.CompanySettlementTemp;
import com.woorinpang.settlementservice.storage.main.db.entity.company.settlement.temp.CompanySettlementTempApply;
import com.woorinpang.settlementservice.storage.main.db.global.entity.BaseEntity;
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
