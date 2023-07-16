package com.woorinpang.settlementservice.domain.store.temp.domain.history.application.exception;

import com.woorinpang.settlementservice.global.exception.EntityNotFoundException;

public class StoreTempSettlementHistoryNotFoundException extends EntityNotFoundException {
    public static final String MESSAGE = "StoreTempSettlementHistoryId=%s은 존재하지 않습니다.";

    public StoreTempSettlementHistoryNotFoundException(Long storeTempSettlementHistoryId) {
        super(MESSAGE.formatted(storeTempSettlementHistoryId));
    }
}
