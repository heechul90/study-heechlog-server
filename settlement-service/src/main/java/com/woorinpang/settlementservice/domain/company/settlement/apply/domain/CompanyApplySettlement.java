package com.woorinpang.settlementservice.domain.company.settlement.apply.domain;

import com.woorinpang.settlementservice.domain.company.settlement.common.domain.CompanyPaymentAmount;
import com.woorinpang.settlementservice.domain.company.settlement.common.domain.CompanySettlementDateYmd;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

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

    @Enumerated(EnumType.STRING)
    private CompanyApprovalType companyApprovalType;

    @Column(columnDefinition = "bigint(20) DEFAULT 0 COMMENT '서비스이용료'")
    private Long serviceAmt;

    @Column(columnDefinition = "bigint(20) DEFAULT 0 COMMENT '정산금액'")
    private Long settleAmt;

    @Column(columnDefinition = "tinyint(4) NOT NULL DEFAULT 0 COMMENT '고객사 결재상태 코드'")
    private Integer approvalTypeCode;

    @Column(columnDefinition = "datetime DEFAULT NULL COMMENT '결재요청일시'")
    private Date approvalDate;

    @Column(name = "approvalID", columnDefinition = "varchar(50) DEFAULT NULL COMMENT '결재자 ID'")
    private String approvalId;

    @Column(columnDefinition = "varchar(1000) DEFAULT NULL COMMENT '반려 사유'")
    private String approvalMemo;

    @Column(columnDefinition = "varchar(30) DEFAULT NULL COMMENT '서비스이용료 텍스트'")
    private String serviceText;

    @Column(columnDefinition = "varchar(30) DEFAULT NULL COMMENT '식대 텍스트'")
    private String mealText;

    @Column(columnDefinition = "char(8) DEFAULT NULL COMMENT '식당 이체 예정일'")
    private String storePredictTransferYMD;

    @Column(name = "depositRequestYMD", columnDefinition = "char(8) DEFAULT NULL COMMENT '입금요청일'")
    private String depositRequestYmd;

    @Column(name = "taxInvoiceYMD", columnDefinition = "char(8) DEFAULT NULL COMMENT '세금계산서 신고일자'")
    private String taxInvoiceYmd;

    @Column(columnDefinition = "bit(1) NOT NULL DEFAULT b'0' COMMENT '세금계산서 단위 처리 결재 락 여부'")
    private boolean taxUnitLockFlag;
}
