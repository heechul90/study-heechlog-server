package com.woorinpang.settlementservice.domain.store.settlement.temp.application.exception;

import com.woorinpang.settlementservice.global.exception.EntityNotFoundException;

public class StoreSettlementTempHistoryNotFoundException extends EntityNotFoundException {
    public static final String MESSAGE = "StoreSettlementTempHistoryId=%s은 존재하지 않습니다.";

    public StoreSettlementTempHistoryNotFoundException(Long storeSettlementTempHistoryId) {
        super(MESSAGE.formatted(storeSettlementTempHistoryId));
    }
}
