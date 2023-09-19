package com.woorinpang.settlementservice.storage.main.db.entity.company.settlement.temp.detail;

import com.woorinpang.settlementservice.storage.main.db.entity.company.common.CompanyId;
import com.woorinpang.settlementservice.storage.main.db.entity.company.common.CompanySettlementTempAmount;
import com.woorinpang.settlementservice.storage.main.db.entity.company.settlement.temp.CompanySettlementTemp;
import com.woorinpang.settlementservice.storage.main.db.entity.store.common.StoreId;
import com.woorinpang.settlementservice.storage.main.db.global.entity.BaseEntity;
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
