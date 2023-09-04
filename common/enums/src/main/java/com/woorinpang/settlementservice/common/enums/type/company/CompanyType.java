package com.woorinpang.settlementservice.common.enums.type.company;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CompanyType {
    GENERAL("General", "일발"),
    ;

    private final String code;
    private final String description;
}
