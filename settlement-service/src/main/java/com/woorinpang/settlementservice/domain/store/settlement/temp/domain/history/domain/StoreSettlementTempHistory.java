package com.woorinpang.settlementservice.domain.store.settlement.temp.domain.history.domain;

import com.woorinpang.settlementservice.domain.store.settlement.common.domain.StoreId;
import com.woorinpang.settlementservice.domain.store.settlement.common.domain.StoreSettlementTempAmount;
import com.woorinpang.settlementservice.domain.store.settlement.common.domain.StoreSettlementDateYmd;
import com.woorinpang.settlementservice.domain.store.settlement.temp.domain.StoreSettlementTemp;
import com.woorinpang.settlementservice.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

/**
 * 스토어 정산임시기록
 */
@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StoreSettlementTempHistory extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_settlement_temp_history_id") @Comment("스토어 정산임시기록 고유번호")
    private Long id;

    @Embedded
    private StoreId storeId;

    @Embedded
    private StoreSettlementDateYmd storeSettlementDateYmd;

    @Embedded
    private StoreSettlementTempAmount storeSettlementTempAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_settlement_temp_id", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private StoreSettlementTemp storeSettlementTemp;

    @Builder(builderMethodName = "createStoreSettlementTempHistory")
    public StoreSettlementTempHistory(StoreId storeId, StoreSettlementDateYmd storeSettlementDateYmd,
                                      StoreSettlementTempAmount storeSettlementTempAmount, StoreSettlementTemp storeSettlementTemp) {
        this.storeId = storeId;
        this.storeSettlementDateYmd = storeSettlementDateYmd;
        this.storeSettlementTempAmount = storeSettlementTempAmount;
        this.storeSettlementTemp = storeSettlementTemp;
    }
}
