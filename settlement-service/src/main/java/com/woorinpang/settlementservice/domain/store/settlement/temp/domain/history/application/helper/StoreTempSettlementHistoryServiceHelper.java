package com.woorinpang.settlementservice.domain.store.settlement.temp.domain.history.application.helper;

import com.woorinpang.settlementservice.domain.store.settlement.temp.domain.history.application.exception.StoreTempSettlementHistoryNotFoundException;
import com.woorinpang.settlementservice.domain.store.settlement.temp.domain.history.domain.StoreTempSettlementHistory;
import com.woorinpang.settlementservice.domain.store.settlement.temp.domain.history.domain.StoreTempSettlementHistoryRepository;

public final class StoreTempSettlementHistoryServiceHelper {
    public static StoreTempSettlementHistory findStoreTempSettlementHistoryById(StoreTempSettlementHistoryRepository storeTempSettlementHistoryRepository,
                                                                                Long storeTempSettlementHistoryId) {
        return storeTempSettlementHistoryRepository.findById(storeTempSettlementHistoryId)
                .orElseThrow(() -> new StoreTempSettlementHistoryNotFoundException(storeTempSettlementHistoryId));
    }

    public static StoreTempSettlementHistory saveStoreTempSettlementHistory(StoreTempSettlementHistoryRepository storeTempSettlementHistoryRepository,
                                                                            StoreTempSettlementHistory storeTempSettlementHistory) {
        return storeTempSettlementHistoryRepository.save(storeTempSettlementHistory);
    }
}
