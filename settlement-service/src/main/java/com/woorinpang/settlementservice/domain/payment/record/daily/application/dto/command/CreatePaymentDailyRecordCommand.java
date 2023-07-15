package com.woorinpang.settlementservice.domain.payment.record.daily.application.dto.command;

import com.woorinpang.settlementservice.domain.payment.record.common.domain.PaymentAmount;
import com.woorinpang.settlementservice.domain.payment.record.daily.domain.PaymentDailyRecord;
import com.woorinpang.settlementservice.domain.payment.record.original.domain.PaymentOriginalRecord;
import com.woorinpang.settlementservice.global.common.entity.YearMonthDay;
import lombok.Builder;

import java.util.List;

@Builder
public record CreatePaymentDailyRecordCommand(
    Long companyId,
    Long storeId,
    YearMonthDay paymentDateYmd
) {
    public PaymentDailyRecord toPaymentDailyRecord(PaymentAmount paymentAmount) {
        return PaymentDailyRecord.createPaymentDailyRecord()
                .companyId(this.companyId)
                .storeId(this.storeId)
                .paymentAmount(paymentAmount)
                .paymentDateYmd(this.paymentDateYmd)
                .build();
    }
}
