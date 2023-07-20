package com.woorinpang.settlementservice.domain.company.settlement.temp.domain.detail.domain;

import com.woorinpang.settlementservice.domain.company.settlement.common.domain.CompanyId;
import com.woorinpang.settlementservice.domain.company.settlement.common.domain.CompanyPaymentAmount;
import com.woorinpang.settlementservice.domain.company.settlement.temp.domain.CompanyTempSettlement;
import com.woorinpang.settlementservice.domain.store.settlement.common.domain.StoreId;
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
public class CompanyTempSettlementDetail extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_temp_settlement_detail_id")
    @Comment("회사 임시정산상세 고유번호")
    private Long id;

    @Embedded
    private CompanyId companyId;

    @Embedded
    private StoreId storeId;

    @Embedded
    private CompanyPaymentAmount companyPaymentAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_temp_settlement_id")
    private CompanyTempSettlement companyTempSettlement;
}
