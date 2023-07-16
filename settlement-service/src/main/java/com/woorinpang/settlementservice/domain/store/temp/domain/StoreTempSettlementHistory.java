package com.woorinpang.settlementservice.domain.store.temp.domain;

import com.woorinpang.settlementservice.domain.store.common.domain.StorePaymentAmount;
import com.woorinpang.settlementservice.domain.store.common.domain.StoreSettlementDateYmd;
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
public class StoreTempSettlementHistory extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_temp_settlement_history_id") @Comment("제휴사 임시 정산 기록 고유번호")
    private Long id;

    private Long storeId;

    @Embedded
    private StoreSettlementDateYmd storeSettlementDateYmd;

    @Embedded
    private StorePaymentAmount storePaymentAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_temp_settlement_id")
    private StoreTempSettlement storeTempSettlement;
}
