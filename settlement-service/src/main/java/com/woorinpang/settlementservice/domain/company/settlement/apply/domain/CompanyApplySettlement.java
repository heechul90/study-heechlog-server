package com.woorinpang.settlementservice.domain.company.settlement.apply.domain;

import com.woorinpang.settlementservice.domain.company.settlement.common.domain.CompanySettlementDateYmd;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyApplySettlement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_apply_settlement_id") @Comment("회사 반영 정산 고유번호")
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
}
