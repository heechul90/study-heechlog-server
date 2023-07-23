package com.woorinpang.settlementservice.domain.store.settlement.temp.domain;

import com.woorinpang.settlementservice.domain.store.settlement.common.domain.StoreId;
import com.woorinpang.settlementservice.domain.store.settlement.common.domain.StoreSettlementTempAmount;
import com.woorinpang.settlementservice.domain.store.settlement.common.domain.StoreSettlementDateYmd;
import com.woorinpang.settlementservice.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

/**
 * 스토어 정산임시
 */
@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StoreSettlementTemp extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_settlement_temp_id") @Comment("스토어 정산임시 고유번호")
    private Long id;

    @Embedded
    private StoreId storeId;

    @Embedded
    private StoreSettlementDateYmd storeSettlementDateYmd;

    @Embedded
    private StoreSettlementTempAmount storePaymentAmount;

    //@OneToMany(mappedBy = "storeTempSettlement")
    //private List<PaymentDailyRecord> paymentDailyRecords = new ArrayList<>();
}
