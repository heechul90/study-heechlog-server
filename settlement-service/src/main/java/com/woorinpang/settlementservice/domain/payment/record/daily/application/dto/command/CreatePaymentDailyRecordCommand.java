package com.woorinpang.settlementservice.domain.payment.record.daily.application.dto.command;

import com.woorinpang.settlementservice.global.common.entity.YearMonthDay;
import lombok.Builder;

@Builder
public record CreatePaymentDailyRecordCommand(
    YearMonthDay paymentDateYmd
) {
}
