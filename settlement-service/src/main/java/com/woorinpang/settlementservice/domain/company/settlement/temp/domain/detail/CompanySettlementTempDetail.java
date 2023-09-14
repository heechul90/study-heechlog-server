package com.woorinpang.settlementservice.domain.company.settlement.temp.domain.detail;

import com.woorinpang.settlementservice.domain.company.common.entity.CompanyId;
import com.woorinpang.settlementservice.domain.company.common.entity.CompanySettlementTempAmount;
import com.woorinpang.settlementservice.domain.company.settlement.temp.domain.CompanySettlementTemp;
import com.woorinpang.settlementservice.domain.store.common.entity.StoreId;
import com.woorinpang.settlementservice.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

/**
 * 컴퍼니 정산임시상세
 */
@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanySettlementTempDetail extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_settlement_temp_detail_id")
    @Comment("컴퍼니 정산임시상세 고유번호")
    private Long id;

    @Embedded
    private CompanyId companyId;

    @Embedded
    private StoreId storeId;

    @Embedded
    private CompanySettlementTempAmount companySettlementTempAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_settlement_temp_id")
    private CompanySettlementTemp companySettlementTemp;
}
