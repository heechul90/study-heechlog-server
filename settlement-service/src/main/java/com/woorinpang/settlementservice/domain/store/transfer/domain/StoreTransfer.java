package com.woorinpang.settlementservice.domain.store.transfer.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

/**
 * 스토어 이체
 */
@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StoreTransfer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_transfer_id") @Comment("스토어 이체 고유번호")
    private Long id;
}
