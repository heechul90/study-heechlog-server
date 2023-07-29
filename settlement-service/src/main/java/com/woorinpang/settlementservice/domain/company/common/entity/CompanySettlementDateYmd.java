package com.woorinpang.settlementservice.domain.company.common.entity;

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
public class CompanySettlementDateYmd {
    @Column(columnDefinition = "char(8) not null comment '컴퍼니 정산시작일자 년월일'")
    @Convert(converter = YearMonthDayConverter.class)
    private YearMonthDay companySettlementStartDateYmd;

    @Column(columnDefinition = "char(8) not null comment '컴퍼니 정산종료일자 년월일'")
    @Convert(converter = YearMonthDayConverter.class)
    private YearMonthDay companySettlementEndDateYmd;

    public String getCompanySettlementDateYmd() {
        return this.companySettlementStartDateYmd.getYearMonthDay() + "~" + this.companySettlementEndDateYmd.getYearMonthDay();
    }
}
