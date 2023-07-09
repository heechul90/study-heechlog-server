package com.woorinpang.settlementservice.domain.payment.record.original.presentation.dto.response;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class AddPaymentOriginalRecordResponse {
    private Long addedId;
}
