package com.woorinpang.settlementservice.domain.company.settlement.apply.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyApplySettlement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_apply_settlement_id") @Comment("회사 반영 정산 고유번호")
    private Long id;
}
