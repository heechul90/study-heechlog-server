package com.woorinpang.settlementservice.domain.payment.record.domain;

import com.woorinpang.settlementservice.domain.payment.settlement.domain.YearMonthDay;
import com.woorinpang.settlementservice.domain.payment.settlement.domain.YearMonthDayConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PaymentCancellation {
    @Column(columnDefinition = "datetime(6) null comment '결제 취소일자'")
    private LocalDateTime paymentCancellationDate;

    @Column(columnDefinition = "char(8) null comment '결제 취소일자 년월일'")
    @Convert(converter = YearMonthDayConverter.class)
    private YearMonthDay paymentCancellationYmd;

    @Column(columnDefinition = "varchar(255) null comment '결제 취소사유'")
    private String paymentCancellationReason;
}
