package com.woorinpang.settlementservice.domain.company.settlement.temp.application.exception;

import com.woorinpang.settlementservice.global.exception.EntityNotFoundException;

public class CompanySettlementTempNotFoundException extends EntityNotFoundException {
    public static final String MESSAGE = "CompanySettlementTempId=%s은 존재하지 않습니다.";

    public CompanySettlementTempNotFoundException(Long companySettlementTempId) {
        super(MESSAGE.formatted(companySettlementTempId));
    }
}
