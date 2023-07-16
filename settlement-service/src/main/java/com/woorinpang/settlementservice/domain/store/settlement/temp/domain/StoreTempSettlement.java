package com.woorinpang.settlementservice.domain.store.settlement.temp.domain;

import com.woorinpang.settlementservice.domain.store.settlement.common.domain.StorePaymentAmount;
import com.woorinpang.settlementservice.domain.store.settlement.common.domain.StoreSettlementDateYmd;
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
public class StoreTempSettlement extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_temp_settlement_id") @Comment("제휴사 임시 정산 고유번호")
    private Long id;

    private Long storeId;

    @Embedded
    private StoreSettlementDateYmd storeSettlementDateYmd;

    @Embedded
    private StorePaymentAmount storePaymentAmount;

    //@OneToMany(mappedBy = "storeTempSettlement")
    //private List<PaymentDailyRecord> paymentDailyRecords = new ArrayList<>();
}
