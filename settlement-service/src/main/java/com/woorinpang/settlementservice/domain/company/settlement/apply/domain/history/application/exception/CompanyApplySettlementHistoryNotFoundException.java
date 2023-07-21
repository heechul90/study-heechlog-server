package com.woorinpang.settlementservice.domain.company.settlement.apply.domain.history.application.exception;

import com.woorinpang.settlementservice.global.exception.EntityNotFoundException;

public class CompanyApplySettlementHistoryNotFoundException extends EntityNotFoundException {
    public static final String MESSAGE = "CompanyApplySettlementHistoryId=%s은 존재하지 않습니다.";

    public CompanyApplySettlementHistoryNotFoundException(Long companyApplySettlementHistoryId) {
        super(MESSAGE.formatted(companyApplySettlementHistoryId));
    }
}
