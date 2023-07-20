package com.woorinpang.settlementservice.domain.company.settlement.temp.domain.history.application.exception;

import com.woorinpang.settlementservice.global.exception.EntityNotFoundException;

public class CompanyTempSettlementHistoryNotFoundException extends EntityNotFoundException {
    public static final String MESSAGE = "CompanyTempSettlementHistoryId=%s은 존재하지 않습니다.";

    public CompanyTempSettlementHistoryNotFoundException(Long companyTempSettlementHistoryId) {
        super(MESSAGE.formatted(companyTempSettlementHistoryId));
    }
}
