package com.woorinpang.settlementservice.domain.company.settlement.ledger.domain;

import com.woorinpang.settlementservice.global.common.entity.YearMonthDay;
import com.woorinpang.settlementservice.global.common.entity.YearMonthDayConverter;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyBankInformation {
    @Column(columnDefinition = "char(8) not null comment '입금요청일자 년월일'")
    @Convert(converter = YearMonthDayConverter.class)
    private YearMonthDay depositRequestYmd; //입금요청일

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(15) not null comment '은행'")
    private Bank bank;
}
