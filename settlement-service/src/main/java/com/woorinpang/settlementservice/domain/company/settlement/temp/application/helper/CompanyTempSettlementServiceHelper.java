package com.woorinpang.settlementservice.domain.company.settlement.temp.application.helper;

import com.woorinpang.settlementservice.domain.company.settlement.temp.application.exception.CompanyTempSettlementNotFoundException;
import com.woorinpang.settlementservice.domain.company.settlement.temp.domain.CompanyTempSettlement;
import com.woorinpang.settlementservice.domain.company.settlement.temp.domain.CompanyTempSettlementRepository;
import com.woorinpang.settlementservice.domain.company.settlement.temp.domain.history.domain.CompanyTempSettlementHistoryRepository;

import static com.woorinpang.settlementservice.domain.company.settlement.temp.domain.history.application.helper.CompanyTempSettlementHistoryServiceHelper.saveCompanyTempSettlementHistory;

public final class CompanyTempSettlementServiceHelper {
    /**
     * 회사 임시정산 단건조회
     */
    public CompanyTempSettlement findCompanyTempSettlementById(CompanyTempSettlementRepository companyTempSettlementRepository,
                                                               Long companyTempSettlementId) {
        return companyTempSettlementRepository.findById(companyTempSettlementId)
                .orElseThrow(() -> new CompanyTempSettlementNotFoundException(companyTempSettlementId));
    }

    /**
     * 회사 임시정산 저장
     */
    public CompanyTempSettlement saveCompanyTempSettlement(CompanyTempSettlementRepository companyTempSettlementRepository,
                                                           CompanyTempSettlementHistoryRepository companyTempSettlementHistoryRepository,
                                                           CompanyTempSettlement companyTempSettlement) {
        CompanyTempSettlement savedCompanyTempSettlement = companyTempSettlementRepository.save(companyTempSettlement);

        //save history
        saveCompanyTempSettlementHistory(companyTempSettlementHistoryRepository, savedCompanyTempSettlement);

        return savedCompanyTempSettlement;
    }
}
