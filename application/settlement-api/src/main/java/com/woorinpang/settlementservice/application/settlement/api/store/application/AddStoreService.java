package com.woorinpang.settlementservice.application.settlement.api.store.application;

import com.woorinpang.settlementservice.domain.store.domain.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AddStoreService {
    private final StoreRepository storeRepository;

    public Long add(String storeName) {
        return storeRepository.add(storeName);
    }
}
