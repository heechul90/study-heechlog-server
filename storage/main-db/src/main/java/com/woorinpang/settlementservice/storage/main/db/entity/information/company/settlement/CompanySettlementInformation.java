package com.woorinpang.settlementservice.storage.main.db.entity.information.company.settlement;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

/**
 * 컴퍼니 정산정보
 */
@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanySettlementInformation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_settlement_information_id") @Comment("컴퍼니 정산정보 고유번호")
    private Long id;
}
