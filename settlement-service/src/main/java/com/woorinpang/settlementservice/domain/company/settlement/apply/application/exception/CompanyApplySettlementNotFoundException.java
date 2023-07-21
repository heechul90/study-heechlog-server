package com.woorinpang.settlementservice.domain.company.settlement.apply.application.exception;

import com.woorinpang.settlementservice.global.exception.EntityNotFoundException;

public class CompanyApplySettlementNotFoundException extends EntityNotFoundException {
    public static final String MESSAGE = "CompanyApplySettlementId=%s은 존재하지 않습니다.";

    public CompanyApplySettlementNotFoundException(Long companyApplySettlementId) {
        super(MESSAGE.formatted(companyApplySettlementId));
    }
}
