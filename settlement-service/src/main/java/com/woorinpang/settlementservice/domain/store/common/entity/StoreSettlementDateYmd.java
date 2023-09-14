package com.woorinpang.settlementservice.domain.store.common.entity;

import com.woorinpang.settlementservice.global.common.entity.YearMonthDay;
import com.woorinpang.settlementservice.global.common.entity.YearMonthDayConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 스토어 정산일자
 */
@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StoreSettlementDateYmd {
    @Column(columnDefinition = "char(8) not null comment '스토어 정산시작일자 년월일'")
    @Convert(converter = YearMonthDayConverter.class)
    private YearMonthDay storeSettlementStartDateYmd;

    @Column(columnDefinition = "char(8) not null comment '스토어 정산종료일자 년월일'")
    @Convert(converter = YearMonthDayConverter.class)
    private YearMonthDay storeSettlementEndDateYmd;

    public String getStoreSettlementDateYmd() {
        return this.storeSettlementStartDateYmd.getYearMonthDay() + "~" + this.storeSettlementEndDateYmd.getYearMonthDay();
    }
}
