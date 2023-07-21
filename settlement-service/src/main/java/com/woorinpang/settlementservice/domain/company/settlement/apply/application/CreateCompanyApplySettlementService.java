package com.woorinpang.settlementservice.domain.company.settlement.apply.application;

import com.woorinpang.settlementservice.domain.company.settlement.apply.domain.CompanyApplySettlementRepository;
import com.woorinpang.settlementservice.domain.company.settlement.apply.infrastructure.CompanyApplySettlementQueryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CreateCompanyApplySettlementService {
    private final CompanyApplySettlementRepository companyApplySettlementRepository;
    private final CompanyApplySettlementQueryRepository companyApplySettlementQueryRepository;
}
