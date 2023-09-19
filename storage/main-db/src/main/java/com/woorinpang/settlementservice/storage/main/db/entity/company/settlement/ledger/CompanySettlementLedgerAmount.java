package com.woorinpang.settlementservice.storage.main.db.entity.company.settlement.ledger;

import com.woorinpang.settlementservice.common.objects.Amount;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanySettlementLedgerAmount {
    @Embedded
    @AttributeOverrides(@AttributeOverride(
            name = "amount",
            column = @Column(name = "taxInvoiceAmount", columnDefinition = "decimal(38,2) default 0 comment '세금계산서 금액'")))
    private Amount taxInvoiceAmount;

    @Embedded
    @AttributeOverrides(@AttributeOverride(
            name = "amount",
            column = @Column(name = "companySettlementAmount", columnDefinition = "decimal(38,2) default 0 comment '컴퍼니 정산금액'")))
    private Amount companySettlementAmount;
}
