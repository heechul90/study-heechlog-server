package com.woorinpang.settlementservice.domain.company.settlement.apply.application.exception;

import com.woorinpang.settlementservice.global.exception.EntityNotFoundException;

public class CompanySettlementApplyNotFoundException extends EntityNotFoundException {
    public static final String MESSAGE = "CompanySettlementApplyId=%s은 존재하지 않습니다.";

    public CompanySettlementApplyNotFoundException(Long companySettlementApplyId) {
        super(MESSAGE.formatted(companySettlementApplyId));
    }
}
