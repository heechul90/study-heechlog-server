package com.woorinpang.settlementservice.domain.company.settlement.apply.application.exception;

import com.woorinpang.settlementservice.global.exception.EntityNotFoundException;

public class CompanySettlementApplyHistoryNotFoundException extends EntityNotFoundException {
    public static final String MESSAGE = "CompanySettlementApplyHistoryId=%s은 존재하지 않습니다.";

    public CompanySettlementApplyHistoryNotFoundException(Long companySettlementApplyHistoryId) {
        super(MESSAGE.formatted(companySettlementApplyHistoryId));
    }
}
