package com.woorinpang.settlementservice.domain.store.domain;

import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository {
    Long add(String storeName);
}
