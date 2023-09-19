package com.woorinpang.settlementservice.storage.main.db.entity.store.invoice;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

/**
 * 스토어 세금계산서
 */
@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StoreTaxInvoice {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_tax_invoice_id") @Comment("스토어 세금계산서 고유번호")
    private Long id;
}
