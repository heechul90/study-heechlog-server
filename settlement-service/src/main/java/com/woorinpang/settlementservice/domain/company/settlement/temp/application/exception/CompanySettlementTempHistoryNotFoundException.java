package com.woorinpang.settlementservice.domain.company.settlement.temp.application.exception;

import com.woorinpang.settlementservice.global.exception.EntityNotFoundException;

public class CompanySettlementTempHistoryNotFoundException extends EntityNotFoundException {
    public static final String MESSAGE = "CompanySettlementTempHistoryId=%s은 존재하지 않습니다.";

    public CompanySettlementTempHistoryNotFoundException(Long companySettlementTempHistoryId) {
        super(MESSAGE.formatted(companySettlementTempHistoryId));
    }
}
