package com.woorinpang.settlementservice.domain.payment.settlement.domain;

import jakarta.persistence.AttributeConverter;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.hasText;

//@Converter(autoApply = true)
public class YearMonthDayConverter implements AttributeConverter<YearMonthDay, String> {
    @Override
    public String convertToDatabaseColumn(YearMonthDay attribute) {
        if (isNull(attribute)) return null;
        return attribute.getYear() + attribute.getMonth() + attribute.getDay();
    }

    @Override
    public YearMonthDay convertToEntityAttribute(String dbData) {
        if(!hasText(dbData)) return null;
        return YearMonthDay.builder()
                .year(dbData.substring(0, 4))
                .month(dbData.substring(4, 6))
                .day(dbData.substring(6, 8))
                .build();
    }
}
