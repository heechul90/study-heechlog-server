package com.woorinpang.settlementservice.domain.company.settlement.apply.application.helper;

import com.woorinpang.settlementservice.domain.company.settlement.apply.application.exception.CompanyApplySettlementNotFoundException;
import com.woorinpang.settlementservice.domain.company.settlement.apply.domain.CompanyApplySettlement;
import com.woorinpang.settlementservice.domain.company.settlement.apply.domain.CompanyApplySettlementRepository;

public final class CompanyApplySettlementServiceHelper {
    public CompanyApplySettlement findCompanyApplySettlementById(CompanyApplySettlementRepository companyApplySettlementRepository,
                                                                 Long companyApplySettlementId) {
        return companyApplySettlementRepository.findById(companyApplySettlementId)
                .orElseThrow(() -> new CompanyApplySettlementNotFoundException(companyApplySettlementId));
    }

    public CompanyApplySettlement saveCompanyApplySettlement(CompanyApplySettlementRepository companyApplySettlementRepository,
                                                             CompanyApplySettlement companyApplySettlement) {
        CompanyApplySettlement savedCompanyApplySettlement = companyApplySettlementRepository.save(companyApplySettlement);

        //save companyApplySettlement

        return savedCompanyApplySettlement;
    }
}
