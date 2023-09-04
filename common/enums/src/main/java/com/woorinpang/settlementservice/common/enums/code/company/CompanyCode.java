package com.woorinpang.settlementservice.common.enums.code.company;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CompanyCode {
    CODE1("code1", "코드1"),
    ;

    private final String code;
    private final String description;
}
