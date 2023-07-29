package com.woorinpang.settlementservice.domain.company.settlement.temp.domain;

import com.woorinpang.settlementservice.domain.company.common.entity.CompanyId;
import com.woorinpang.settlementservice.domain.company.common.entity.CompanySettlementTempAmount;
import com.woorinpang.settlementservice.domain.company.common.entity.CompanySettlementDateYmd;
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
