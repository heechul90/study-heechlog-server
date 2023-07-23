package com.woorinpang.settlementservice.domain.company.settlement.apply.domain;

import com.woorinpang.settlementservice.domain.company.settlement.common.domain.CompanySettlementDateYmd;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

/**
 * 컴퍼니 정산반영
 */
@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanySettlementApply {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_settlement_apply_id") @Comment("컴퍼니 정산반영 고유번호")
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
}
