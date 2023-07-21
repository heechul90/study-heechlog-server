package com.woorinpang.settlementservice.domain.company.settlement.temp.domain.history.application.helper;

import com.woorinpang.settlementservice.domain.company.settlement.temp.domain.CompanyTempSettlement;
import com.woorinpang.settlementservice.domain.company.settlement.temp.domain.history.application.exception.CompanyTempSettlementHistoryNotFoundException;
import com.woorinpang.settlementservice.domain.company.settlement.temp.domain.history.domain.CompanyTempSettlementHistory;
import com.woorinpang.settlementservice.domain.company.settlement.temp.domain.history.domain.CompanyTempSettlementHistoryRepository;

public final class CompanyTempSettlementHistoryServiceHelper {
    /**
     * 회사 임시정산기록 단건조회
     */
    public static CompanyTempSettlementHistory findCompanyTempSettlementById(CompanyTempSettlementHistoryRepository companyTempSettlementHistoryRepository,
                                                                      Long companyTempSettlementHistoryId) {
        return companyTempSettlementHistoryRepository.findById(companyTempSettlementHistoryId)
                .orElseThrow(() -> new CompanyTempSettlementHistoryNotFoundException(companyTempSettlementHistoryId));
    }

    /**
     * 회사 임시정산기록 저장
     */
    public static CompanyTempSettlementHistory saveCompanyTempSettlementHistory(CompanyTempSettlementHistoryRepository companyTempSettlementHistoryRepository,
                                                                         CompanyTempSettlement companyTempSettlement) {
        return companyTempSettlementHistoryRepository.save(getCompanyTempSettlementHistory(companyTempSettlement));
    }

    private static CompanyTempSettlementHistory getCompanyTempSettlementHistory(CompanyTempSettlement companyTempSettlement) {
        return CompanyTempSettlementHistory.createCompanyTempSettlementHistory()
                .companyTempSettlement(companyTempSettlement)
                .companyId(companyTempSettlement.getCompanyId())
                .companySettlementDateYmd(companyTempSettlement.getCompanySettlementDateYmd())
                .companyPaymentAmount(companyTempSettlement.getCompanyPaymentAmount())
                .companyTempSettlementApply(companyTempSettlement.getCompanyTempSettlementApply())
                .build();
    }
}
