package com.woorinpang.settlementservice.domain.store.settlement.temp.domain.history.domain;

import com.woorinpang.settlementservice.domain.store.settlement.common.domain.StoreId;
import com.woorinpang.settlementservice.domain.store.settlement.common.domain.StoreSettlementAmount;
import com.woorinpang.settlementservice.domain.store.settlement.common.domain.StoreSettlementDateYmd;
import com.woorinpang.settlementservice.domain.store.settlement.temp.domain.StoreTempSettlement;
import com.woorinpang.settlementservice.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StoreTempSettlementHistory extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_temp_settlement_history_id") @Comment("제휴사 임시정산 기록 고유번호")
    private Long id;

    @EmbeddedId
    private StoreId storeId;

    @Embedded
    private StoreSettlementDateYmd storeSettlementDateYmd;

    @Embedded
    private StoreSettlementAmount storeSettlementAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_temp_settlement_id", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private StoreTempSettlement storeTempSettlement;

    @Builder(builderMethodName = "createStoreTempSettlementHistory")
    public StoreTempSettlementHistory(StoreId storeId, StoreSettlementDateYmd storeSettlementDateYmd,
                                      StoreSettlementAmount storeSettlementAmount, StoreTempSettlement storeTempSettlement) {
        this.storeId = storeId;
        this.storeSettlementDateYmd = storeSettlementDateYmd;
        this.storeSettlementAmount = storeSettlementAmount;
        this.storeTempSettlement = storeTempSettlement;
    }
}
