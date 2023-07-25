package com.woorinpang.settlementservice.domain.store.settlement.temp.domain.detail;

import com.woorinpang.settlementservice.domain.company.settlement.common.domain.CompanyId;
import com.woorinpang.settlementservice.domain.store.settlement.common.domain.StoreId;
import com.woorinpang.settlementservice.domain.store.settlement.common.domain.StoreSettlementTempAmount;
import com.woorinpang.settlementservice.domain.store.settlement.temp.domain.StoreSettlementTemp;
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
public class StoreSettlementTempDetail extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_settlement_temp_detail_id")
    @Comment("스토어 정산임시상세 고유번호")
    private Long id;

    @Embedded
    private StoreId storeId;

    @Embedded
    private CompanyId companyId;

    @Embedded
    private StoreSettlementTempAmount storeSettlementTempAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_settlement_temp_id")
    private StoreSettlementTemp storeSettlementTemp;
}
