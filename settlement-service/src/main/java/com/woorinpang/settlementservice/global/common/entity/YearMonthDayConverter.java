package com.woorinpang.settlementservice.global.common.entity;

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
        return YearMonthDay.of(dbData);
    }
}
