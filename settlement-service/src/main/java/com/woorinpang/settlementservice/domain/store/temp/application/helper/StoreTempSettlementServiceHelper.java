package com.woorinpang.settlementservice.domain.store.temp.application.helper;

import com.woorinpang.settlementservice.domain.store.temp.application.exception.StoreTempSettlementNotFoundException;
import com.woorinpang.settlementservice.domain.store.temp.domain.StoreTempSettlement;
import com.woorinpang.settlementservice.domain.store.temp.domain.StoreTempSettlementRepository;
import com.woorinpang.settlementservice.domain.store.temp.domain.history.application.helper.StoreTempSettlementHistoryServiceHelper;
import com.woorinpang.settlementservice.domain.store.temp.domain.history.domain.StoreTempSettlementHistory;
import com.woorinpang.settlementservice.domain.store.temp.domain.history.domain.StoreTempSettlementHistoryRepository;

import static com.woorinpang.settlementservice.domain.store.temp.domain.history.application.helper.StoreTempSettlementHistoryServiceHelper.*;

public final class StoreTempSettlementServiceHelper {
    /**
     * 제휴사 임시정산 단건조회
     */
    public static StoreTempSettlement findStoreTempSettlementById(StoreTempSettlementRepository storeTempSettlementRepository,
                                                                  Long storeTempSettlementId) {
        return storeTempSettlementRepository.findById(storeTempSettlementId)
                .orElseThrow(() -> new StoreTempSettlementNotFoundException(storeTempSettlementId));
    }

    /**
     * 제휴사 임시정산 저장
     */
    public static StoreTempSettlement saveStoreTempSettlement(StoreTempSettlementRepository storeTempSettlementRepository,
                                                              StoreTempSettlementHistoryRepository storeTempSettlementHistoryRepository,
                                                              StoreTempSettlement storeTempSettlement) {
        StoreTempSettlement savedStoreTempSettlement = storeTempSettlementRepository.save(storeTempSettlement);

        //save history
        saveStoreTempSettlementHistory(storeTempSettlementHistoryRepository, getStoreTempSettlementHistory(savedStoreTempSettlement));
        return savedStoreTempSettlement;
    }

    /**
     * 제휴사 임시정산 삭제
     */
    public static void deleteStoreTempSettlement(StoreTempSettlementRepository storeTempSettlementRepository,
                                                 StoreTempSettlement storeTempSettlement) {
        storeTempSettlementRepository.delete(storeTempSettlement);
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
