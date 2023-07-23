package com.woorinpang.settlementservice.domain.store.settlement.temp.application.helper;

import com.woorinpang.settlementservice.domain.store.settlement.temp.domain.StoreSettlementTemp;
import com.woorinpang.settlementservice.domain.store.settlement.temp.domain.history.domain.StoreSettlementTempHistoryRepository;
import com.woorinpang.settlementservice.domain.store.settlement.temp.application.exception.StoreSettlementTempNotFoundException;
import com.woorinpang.settlementservice.domain.store.settlement.temp.domain.StoreSettlementTempRepository;

import static com.woorinpang.settlementservice.domain.store.settlement.temp.domain.history.application.helper.StoreSettlementTempHistoryServiceHelper.*;

public final class StoreSettlementServiceTempHelper {
    /**
     * 스토어 정산임시 단건조회
     */
    public static StoreSettlementTemp findStoreSettlementTempById(StoreSettlementTempRepository storeSettlementTempRepository,
                                                                  Long storeSettlementTempId) {
        return storeSettlementTempRepository.findById(storeSettlementTempId)
                .orElseThrow(() -> new StoreSettlementTempNotFoundException(storeSettlementTempId));
    }

    /**
     * 스토어 정산임시 저장
     */
    public static StoreSettlementTemp saveStoreSettlementTemp(StoreSettlementTempRepository storeSettlementTempRepository,
                                                              StoreSettlementTempHistoryRepository storeSettlementTempHistoryRepository,
                                                              StoreSettlementTemp storeSettlementTemp) {
        StoreSettlementTemp savedStoreSettlementTemp = storeSettlementTempRepository.save(storeSettlementTemp);

        //save history
        saveStoreSettlementTempHistory(storeSettlementTempHistoryRepository, savedStoreSettlementTemp);
        return savedStoreSettlementTemp;
    }

    /**
     * 스토어 정산임시 삭제
     */
    public static void deleteStoreSettlementTemp(StoreSettlementTempRepository storeSettlementTempRepository,
                                                 StoreSettlementTemp storeSettlementTemp) {
        storeSettlementTempRepository.delete(storeSettlementTemp);
    }
}
