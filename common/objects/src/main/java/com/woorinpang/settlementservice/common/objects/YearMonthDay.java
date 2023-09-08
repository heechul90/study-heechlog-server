package com.woorinpang.settlementservice.common.objects;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class YearMonthDay {
    private String year;
    private String month;
    private String day;

    private YearMonthDay(String year, String month, String day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static YearMonthDay of(String year, String month, String day) {
        return new YearMonthDay(year, month, day);
    }

    public static YearMonthDay of(String yearMonthDay) {
        return new YearMonthDay(yearMonthDay.substring(0, 4), yearMonthDay.substring(4, 6), yearMonthDay.substring(6, 8));
    }

    public String getYearMonthDay() {
        return this.year + this.month + this.day;
    }
}
