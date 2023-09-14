package com.woorinpang.settlementservice.domain.company.settlement.ledger.domain;

import com.woorinpang.settlementservice.global.common.entity.YearMonthDay;
import com.woorinpang.settlementservice.global.common.entity.YearMonthDayConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyBankInformation {
    @Column(columnDefinition = "char(8) not null comment '입금요청일자 년월일'")
    @Convert(converter = YearMonthDayConverter.class)
    private YearMonthDay depositRequestYmd; //입금요청일
}
