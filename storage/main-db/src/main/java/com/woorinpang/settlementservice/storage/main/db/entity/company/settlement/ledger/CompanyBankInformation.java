package com.woorinpang.settlementservice.storage.main.db.entity.company.settlement.ledger;

import com.woorinpang.settlementservice.common.objects.YearMonthDay;
import com.woorinpang.settlementservice.storage.main.db.global.entity.YearMonthDayConverter;
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
