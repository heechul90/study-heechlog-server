package com.woorinpang.settlementservice.storage.main.db.entity.store.settlement.apply;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

/**
 * 스토어 정산반영
 */
@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StoreSettlementApply {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_settlement_apply_id") @Comment("스토어 정산반영 고유번호")
    private Long id;
}
