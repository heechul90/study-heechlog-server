package com.woorinpang.settlementservice.domain.store.settlement.ledger.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

/**
 * 스토어 정산원장
 */
@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StoreSettlementLedger {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_settlement_ledger_id") @Comment("스토어 정산원장 고유번호")
    private Long id;
}
