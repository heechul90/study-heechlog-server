package com.woorinpang.settlementservice.storage.main.db.entity.store.settlement.temp.detail;

import com.woorinpang.settlementservice.storage.main.db.entity.company.common.CompanyId;
import com.woorinpang.settlementservice.storage.main.db.entity.store.common.StoreId;
import com.woorinpang.settlementservice.storage.main.db.entity.store.common.StoreSettlementTempAmount;
import com.woorinpang.settlementservice.storage.main.db.entity.store.settlement.temp.StoreSettlementTemp;
import com.woorinpang.settlementservice.storage.main.db.global.entity.BaseEntity;
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
