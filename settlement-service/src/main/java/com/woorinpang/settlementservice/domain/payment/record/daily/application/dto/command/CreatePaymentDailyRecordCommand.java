package com.woorinpang.settlementservice.domain.payment.record.daily.application.dto.command;

import com.woorinpang.settlementservice.domain.company.settlement.common.entity.CompanyId;
import com.woorinpang.settlementservice.domain.payment.record.common.domain.PaymentAmount;
import com.woorinpang.settlementservice.domain.payment.record.daily.domain.PaymentDailyRecord;
import com.woorinpang.settlementservice.domain.store.settlement.common.entity.StoreId;
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
