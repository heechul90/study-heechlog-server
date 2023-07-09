package com.woorinpang.settlementservice.domain.payment.record.original.presentation.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CancelPaymentOriginalRecordResponse {
    private Long cancelledId;
}
