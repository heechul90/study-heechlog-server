package com.woorinpang.settlementservice.domain.store.settlement.temp.domain.history.application.helper;

import com.woorinpang.settlementservice.domain.store.settlement.temp.domain.StoreTempSettlement;
import com.woorinpang.settlementservice.domain.store.settlement.temp.domain.history.application.exception.StoreTempSettlementHistoryNotFoundException;
import com.woorinpang.settlementservice.domain.store.settlement.temp.domain.history.domain.StoreTempSettlementHistory;
import com.woorinpang.settlementservice.domain.store.settlement.temp.domain.history.domain.StoreTempSettlementHistoryRepository;

public final class StoreTempSettlementHistoryServiceHelper {
    /**
     * 제휴사 임시정산기록 단건 조회
     */
    public static StoreTempSettlementHistory findStoreTempSettlementHistoryById(StoreTempSettlementHistoryRepository storeTempSettlementHistoryRepository,
                                                                                Long storeTempSettlementHistoryId) {
        return storeTempSettlementHistoryRepository.findById(storeTempSettlementHistoryId)
                .orElseThrow(() -> new StoreTempSettlementHistoryNotFoundException(storeTempSettlementHistoryId));
    }

    /**
     * 제휴사 임시정산기록 저장
     */
    public static StoreTempSettlementHistory saveStoreTempSettlementHistory(StoreTempSettlementHistoryRepository storeTempSettlementHistoryRepository,
                                                                            StoreTempSettlement storeTempSettlement) {
        return storeTempSettlementHistoryRepository.save(getStoreTempSettlementHistory(storeTempSettlement));
    }

    private static StoreTempSettlementHistory getStoreTempSettlementHistory(StoreTempSettlement savedStoreTempSettlement) {
        return StoreTempSettlementHistory.createStoreTempSettlementHistory()
                .storeId(savedStoreTempSettlement.getStoreId())
                .storeSettlementDateYmd(savedStoreTempSettlement.getStoreSettlementDateYmd())
                .storePaymentAmount(savedStoreTempSettlement.getStorePaymentAmount())
                .storeTempSettlement(savedStoreTempSettlement)
                .build();
    }
}
