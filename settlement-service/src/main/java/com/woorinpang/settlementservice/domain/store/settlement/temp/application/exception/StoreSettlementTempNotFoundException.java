package com.woorinpang.settlementservice.domain.store.settlement.temp.application.exception;

import com.woorinpang.settlementservice.global.exception.EntityNotFoundException;

public class StoreSettlementTempNotFoundException extends EntityNotFoundException {
    public static final String MESSAGE = "StoreSettlementTempId=%s은 존재하지 않습니다.";

    public StoreSettlementTempNotFoundException(Long storeSettlementTempId) {
        super(MESSAGE.formatted(storeSettlementTempId));
    }
}
