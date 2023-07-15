package com.woorinpang.settlementservice.domain.payment.record.daily.presentation.dto.request;

import com.woorinpang.settlementservice.domain.payment.record.daily.application.dto.command.CreatePaymentDailyRecordCommand;
import com.woorinpang.settlementservice.global.common.entity.YearMonthDay;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreatePaymentDailyRecordRequest {
    @NotNull
    private Long companyId;

    @NotNull
    private Long storeId;

    @NotBlank
    @Length(min = 8, max = 8)
    private String paymentDateYmd;

    public CreatePaymentDailyRecordCommand toCommend() {
        return CreatePaymentDailyRecordCommand.builder()
                .paymentDateYmd(YearMonthDay.of(paymentDateYmd))
                .build();
    }
}
