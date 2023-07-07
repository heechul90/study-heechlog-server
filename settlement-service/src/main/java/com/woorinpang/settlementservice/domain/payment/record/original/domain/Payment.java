package com.woorinpang.settlementservice.domain.payment.record.original.domain;

import com.woorinpang.settlementservice.global.common.entity.YearMonthDay;
import com.woorinpang.settlementservice.global.common.entity.YearMonthDayConverter;
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
public class Payment {
    @Column(columnDefinition = "datetime(6) not null comment '결제일자'")
    private LocalDateTime paymentDate;

    @Column(columnDefinition = "char(8) not null comment '결제일자 년월일'")
    @Convert(converter = YearMonthDayConverter.class)
    private YearMonthDay paymentDateYmd;
}
