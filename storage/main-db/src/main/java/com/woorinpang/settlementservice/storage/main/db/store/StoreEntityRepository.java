package com.woorinpang.settlementservice.storage.main.db.store;

import com.woorinpang.settlementservice.domain.store.domain.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
@Transactional
public class StoreEntityRepository implements StoreRepository {
    private final StoreJpaRepository storeJpaRepository;

    @Override
    public Long add(String storeName) {
        return storeJpaRepository.save(new StoreEntity(storeName)).getId();
    }
}
