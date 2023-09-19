package com.woorinpang.settlementservice.storage.main.db.entity.payment.record.original;

import com.woorinpang.settlementservice.common.objects.YearMonthDay;
import com.woorinpang.settlementservice.storage.main.db.global.entity.YearMonthDayConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 결제
 */
@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Payment {
    @Column(columnDefinition = "datetime(6) not null comment '결제일자'")
    private LocalDateTime paymentDate;

    @Column(columnDefinition = "char(8) not null comment '결제일자 년월일'")
    @Convert(converter = YearMonthDayConverter.class)
    private YearMonthDay paymentDateYmd;
}
