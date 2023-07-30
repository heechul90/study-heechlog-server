package com.woorinpang.settlementservice.domain.payment.record.daily.application.dto.command;

import com.woorinpang.settlementservice.domain.company.common.entity.CompanyId;
import com.woorinpang.settlementservice.domain.payment.common.entity.PaymentAmount;
import com.woorinpang.settlementservice.domain.payment.record.daily.domain.PaymentDailyRecord;
import com.woorinpang.settlementservice.domain.store.common.entity.StoreId;
import com.woorinpang.settlementservice.global.common.entity.YearMonthDay;
import lombok.Builder;

@Builder
public record CreatePaymentDailyRecordCommand(
    CompanyId companyId,
    StoreId storeId,
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
