package com.woorinpang.settlementservice.domain.company.settlement.apply.application.helper;

import com.woorinpang.settlementservice.domain.company.settlement.apply.application.exception.CompanyApplySettlementNotFoundException;
import com.woorinpang.settlementservice.domain.company.settlement.apply.domain.CompanyApplySettlement;
import com.woorinpang.settlementservice.domain.company.settlement.apply.domain.CompanyApplySettlementRepository;
import com.woorinpang.settlementservice.domain.company.settlement.apply.domain.history.application.helper.CompanyApplySettlementHistoryServiceHelper;
import com.woorinpang.settlementservice.domain.company.settlement.apply.domain.history.domain.CompanyApplySettlementHistoryRepository;

import static com.woorinpang.settlementservice.domain.company.settlement.apply.domain.history.application.helper.CompanyApplySettlementHistoryServiceHelper.*;

public final class CompanyApplySettlementServiceHelper {
    /**
     * 회사 작용정산 단건조회
     */
    public CompanyApplySettlement findCompanyApplySettlementById(CompanyApplySettlementRepository companyApplySettlementRepository,
                                                                 Long companyApplySettlementId) {
        return companyApplySettlementRepository.findById(companyApplySettlementId)
                .orElseThrow(() -> new CompanyApplySettlementNotFoundException(companyApplySettlementId));
    }

    /**
     * 회사 작용정산 저장
     */
    public CompanyApplySettlement saveCompanyApplySettlement(CompanyApplySettlementRepository companyApplySettlementRepository,
                                                             CompanyApplySettlementHistoryRepository companyApplySettlementHistoryRepository,
                                                             CompanyApplySettlement companyApplySettlement) {
        CompanyApplySettlement savedCompanyApplySettlement = companyApplySettlementRepository.save(companyApplySettlement);

        //save companyApplySettlement
        saveCompanyApplySettlementHistory(companyApplySettlementHistoryRepository, savedCompanyApplySettlement);

        return savedCompanyApplySettlement;
    }
}
