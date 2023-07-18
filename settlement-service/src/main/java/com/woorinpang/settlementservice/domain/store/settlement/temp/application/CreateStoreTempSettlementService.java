package com.woorinpang.settlementservice.domain.store.settlement.temp.application;

import com.woorinpang.settlementservice.domain.store.settlement.temp.domain.StoreTempSettlementRepository;
import com.woorinpang.settlementservice.domain.store.settlement.temp.infrastructure.StoreTempSettlementQueryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CreateStoreTempSettlementService {
    private final StoreTempSettlementRepository storeTempSettlementRepository;
    private final StoreTempSettlementQueryRepository storeTempSettlementQueryRepository;
}
