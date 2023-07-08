package com.woorinpang.settlementservice.domain.payment.record.original.infrastructure.dto.search;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PaymentOriginalRecordSearchCondition {
    private Long searchCompanyId;
    private Long searchStoreId;
    private Long searchUserId;
}
