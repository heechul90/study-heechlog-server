package com.woorinpang.settlementservice.domain.company.settlement.apply.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyApproval {
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(15) not null comment '컴퍼니 결재 상태'")
    private CompanyApprovalStatus companyApprovalStatus;

    @Column(columnDefinition = "datetime(6) null comment '결재요청 일자'")
    private LocalDateTime approvalRequestDate;

    @Column(columnDefinition = "datetime(6) null comment '결재된 일자'")
    private LocalDateTime approvedDate;

    @Column(columnDefinition = "varchar(60) null comment '결재자 고유번호")
    private Long approvalId;

    @Column(columnDefinition = "varchar(120) null comment '미결재 사유")
    private String disapprovedReason;
}
