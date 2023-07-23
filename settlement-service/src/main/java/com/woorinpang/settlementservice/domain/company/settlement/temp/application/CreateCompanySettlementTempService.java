package com.woorinpang.settlementservice.domain.company.settlement.temp.application;

import com.woorinpang.settlementservice.domain.company.settlement.temp.domain.CompanySettlementTempRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CreateCompanySettlementTempService {
    private final CompanySettlementTempRepository companySettlementTempRepository;
}
