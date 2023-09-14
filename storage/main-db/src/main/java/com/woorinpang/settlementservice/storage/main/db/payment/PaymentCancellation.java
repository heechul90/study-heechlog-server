package com.woorinpang.settlementservice.storage.main.db.payment;

import com.woorinpang.settlementservice.common.objects.YearMonthDay;
import com.woorinpang.settlementservice.storage.main.db.global.entity.YearMonthDayConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 결제 취소
 */
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

    @Builder
    public PaymentCancellation(LocalDateTime paymentCancellationDate, YearMonthDay paymentCancellationYmd, String paymentCancellationReason) {
        this.paymentCancellationDate = paymentCancellationDate;
        this.paymentCancellationYmd = paymentCancellationYmd;
        this.paymentCancellationReason = paymentCancellationReason;
    }
}
