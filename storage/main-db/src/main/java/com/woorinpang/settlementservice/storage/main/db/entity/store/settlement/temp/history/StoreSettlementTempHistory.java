package com.woorinpang.settlementservice.storage.main.db.entity.store.settlement.temp.history;

import com.woorinpang.settlementservice.storage.main.db.entity.store.common.StoreId;
import com.woorinpang.settlementservice.storage.main.db.entity.store.common.StoreSettlementDateYmd;
import com.woorinpang.settlementservice.storage.main.db.entity.store.common.StoreSettlementTempAmount;
import com.woorinpang.settlementservice.storage.main.db.entity.store.settlement.temp.StoreSettlementTemp;
import com.woorinpang.settlementservice.storage.main.db.global.entity.BaseEntity;
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
