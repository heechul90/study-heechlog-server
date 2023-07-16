package com.woorinpang.settlementservice.domain.store.settlement.temp.application.exception;

import com.woorinpang.settlementservice.global.exception.EntityNotFoundException;

public class StoreTempSettlementNotFoundException extends EntityNotFoundException {
    public static final String MESSAGE = "StoreTempSettlementId=%s은 존재하지 않습니다.";

    public StoreTempSettlementNotFoundException(Long storeTempSettlementId) {
        super(MESSAGE.formatted(storeTempSettlementId));
    }
}
