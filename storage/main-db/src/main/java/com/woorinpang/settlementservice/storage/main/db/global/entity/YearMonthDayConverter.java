package com.woorinpang.settlementservice.storage.main.db.global.entity;

import com.woorinpang.settlementservice.common.objects.YearMonthDay;
import jakarta.persistence.AttributeConverter;
import org.springframework.util.StringUtils;

import static java.util.Objects.isNull;

//@Converter(autoApply = true)
public class YearMonthDayConverter implements AttributeConverter<YearMonthDay, String> {
    @Override
    public String convertToDatabaseColumn(YearMonthDay attribute) {
        if (isNull(attribute)) return null;
        return attribute.getYear() + attribute.getMonth() + attribute.getDay();
    }

    @Override
    public YearMonthDay convertToEntityAttribute(String dbData) {
        if(!StringUtils.hasText(dbData)) return null;
        return YearMonthDay.of(dbData);
    }
}
