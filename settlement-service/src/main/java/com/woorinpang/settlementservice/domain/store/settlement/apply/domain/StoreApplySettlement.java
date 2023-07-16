package com.woorinpang.settlementservice.domain.store.settlement.apply.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StoreApplySettlement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_apply_settlement_id") @Comment("제휴사 반영 정산 고유번호")
    private Long id;
}
