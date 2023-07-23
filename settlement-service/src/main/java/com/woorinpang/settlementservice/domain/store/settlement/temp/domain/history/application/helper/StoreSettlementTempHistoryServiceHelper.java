package com.woorinpang.settlementservice.domain.store.settlement.temp.domain.history.application.helper;

import com.woorinpang.settlementservice.domain.store.settlement.temp.domain.StoreSettlementTemp;
import com.woorinpang.settlementservice.domain.store.settlement.temp.domain.history.application.exception.StoreSettlementTempHistoryNotFoundException;
import com.woorinpang.settlementservice.domain.store.settlement.temp.domain.history.domain.StoreSettlementTempHistory;
import com.woorinpang.settlementservice.domain.store.settlement.temp.domain.history.domain.StoreSettlementTempHistoryRepository;

public final class StoreSettlementTempHistoryServiceHelper {
    /**
     * 스토어 정산임시기록 단건 조회
     */
    public static StoreSettlementTempHistory findStoreSettlementTempHistoryById(StoreSettlementTempHistoryRepository storeSettlementTempHistoryRepository,
                                                                                Long storeSettlementTempHistoryId) {
        return storeSettlementTempHistoryRepository.findById(storeSettlementTempHistoryId)
                .orElseThrow(() -> new StoreSettlementTempHistoryNotFoundException(storeSettlementTempHistoryId));
    }

    /**
     * 스토어 정산임시기록 저장
     */
    public static StoreSettlementTempHistory saveStoreSettlementTempHistory(StoreSettlementTempHistoryRepository storeSettlementTempHistoryRepository,
                                                                            StoreSettlementTemp storeSettlementTemp) {
        return storeSettlementTempHistoryRepository.save(getStoreSettlementTempHistory(storeSettlementTemp));
    }

    private static StoreSettlementTempHistory getStoreSettlementTempHistory(StoreSettlementTemp storeSettlementTemp) {
        return StoreSettlementTempHistory.createStoreSettlementTempHistory()
                .storeId(storeSettlementTemp.getStoreId())
                .storeSettlementDateYmd(storeSettlementTemp.getStoreSettlementDateYmd())
                .storeSettlementTempAmount(storeSettlementTemp.getStorePaymentAmount())
                .storeSettlementTemp(storeSettlementTemp)
                .build();
    }
}
