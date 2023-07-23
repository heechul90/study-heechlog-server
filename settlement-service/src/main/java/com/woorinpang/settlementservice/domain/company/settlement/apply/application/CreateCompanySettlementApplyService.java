package com.woorinpang.settlementservice.domain.company.settlement.apply.application;

import com.woorinpang.settlementservice.domain.company.settlement.apply.domain.CompanySettlementApplyRepository;
import com.woorinpang.settlementservice.domain.company.settlement.apply.infrastructure.CompanySettlementApplyQueryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CreateCompanySettlementApplyService {
    private final CompanySettlementApplyRepository companySettlementApplyRepository;
    private final CompanySettlementApplyQueryRepository companySettlementApplyQueryRepository;
}
