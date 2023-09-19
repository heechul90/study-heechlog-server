package com.woorinpang.settlementservice.storage.main.db.entity.company.invoice;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

/**
 * 컴퍼니 세금계산서
 */
@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyTaxInvoice {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_tax_invoice_id") @Comment("컴퍼니 세금계산서 고유번호")
    private Long id;
}
