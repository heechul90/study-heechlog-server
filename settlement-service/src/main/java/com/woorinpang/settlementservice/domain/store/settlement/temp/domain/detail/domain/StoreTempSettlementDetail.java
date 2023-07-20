package com.woorinpang.settlementservice.domain.store.settlement.temp.domain.detail.domain;

import com.woorinpang.settlementservice.domain.store.settlement.common.domain.StoreId;
import com.woorinpang.settlementservice.domain.company.settlement.common.domain.CompanyId;
import com.woorinpang.settlementservice.domain.store.settlement.common.domain.StoreSettlementAmount;
import com.woorinpang.settlementservice.domain.store.settlement.temp.domain.StoreTempSettlement;
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
public class StoreTempSettlementDetail extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_temp_settlement_detail_id")
    @Comment("제휴사 임시 정산 상세 고유번호")
    private Long id;

    @EmbeddedId
    private StoreId storeId;

    @EmbeddedId
    private CompanyId companyId;

    @Embedded
    private StoreSettlementAmount storePaymentAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_temp_settlement_id")
    private StoreTempSettlement storeTempSettlement;
}
