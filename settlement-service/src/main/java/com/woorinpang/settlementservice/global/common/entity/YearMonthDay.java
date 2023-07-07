package com.woorinpang.settlementservice.global.common.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class YearMonthDay {
    private String year;
     private String month;
    private String day;

    @Builder
    public YearMonthDay(String year, String month, String day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
}
