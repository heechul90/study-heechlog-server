package com.woorinpang.settlementservice.domain.company.settlement.temp.application.exception;

import com.woorinpang.settlementservice.global.exception.EntityNotFoundException;

public class CompanyTempSettlementNotFoundException extends EntityNotFoundException {
    public static final String MESSAGE = "CompanyTempSettlementId=%s은 존재하지 않습니다.";

    public CompanyTempSettlementNotFoundException(Long companyTempSettlementId) {
        super(MESSAGE.formatted(companyTempSettlementId));
    }
}
