package com.woorinpang.settlementservice.storage.main.db.entity.company.settlement.temp;

import com.woorinpang.settlementservice.storage.main.db.entity.company.common.CompanyId;
import com.woorinpang.settlementservice.storage.main.db.entity.company.common.CompanySettlementDateYmd;
import com.woorinpang.settlementservice.storage.main.db.entity.company.common.CompanySettlementTempAmount;
import com.woorinpang.settlementservice.storage.main.db.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

/**
 * 컴퍼니 정산임시
 */
@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanySettlementTemp extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_settlement_temp_id") @Comment("컴퍼니 정산임시 고유번호")
    private Long id;

    @Embedded
    private CompanyId companyId;

    @Embedded
    private CompanySettlementDateYmd companySettlementDateYmd;

    @Embedded
    private CompanySettlementTempAmount companySettlementTempAmount;

    @Embedded
    private CompanySettlementTempApply companySettlementTempApply;
}
