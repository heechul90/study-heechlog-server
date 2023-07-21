package com.woorinpang.settlementservice.domain.company.settlement.apply.domain.history.application.helper;

import com.woorinpang.settlementservice.domain.company.settlement.apply.domain.CompanyApplySettlement;
import com.woorinpang.settlementservice.domain.company.settlement.apply.domain.history.application.exception.CompanyApplySettlementHistoryNotFoundException;
import com.woorinpang.settlementservice.domain.company.settlement.apply.domain.history.domain.CompanyApplySettlementHistory;
import com.woorinpang.settlementservice.domain.company.settlement.apply.domain.history.domain.CompanyApplySettlementHistoryRepository;

public final class CompanyApplySettlementHistoryServiceHelper {
    /**
     * 회사 적용정산기록 단건 조회
     */
    public static CompanyApplySettlementHistory findCompanyApplySettlementHistoryById(CompanyApplySettlementHistoryRepository companyApplySettlementHistoryRepository,
                                                                                      Long companyApplySettlementHistoryId) {
        return companyApplySettlementHistoryRepository.findById(companyApplySettlementHistoryId)
                .orElseThrow(() -> new CompanyApplySettlementHistoryNotFoundException(companyApplySettlementHistoryId));
    }

    /**
     * 회사 적용정산기록 저장
     */
    public static CompanyApplySettlementHistory saveCompanyApplySettlementHistory(CompanyApplySettlementHistoryRepository companyApplySettlementHistoryRepository,
                                                                                  CompanyApplySettlement companyApplySettlement) {
        return companyApplySettlementHistoryRepository.save(getCompanyApplySettlementHistory(companyApplySettlement));
    }

    private static CompanyApplySettlementHistory getCompanyApplySettlementHistory(CompanyApplySettlement companyApplySettlement) {
        return CompanyApplySettlementHistory.createCompanyApplySettlementHistory()
                .companyApplySettlement(companyApplySettlement)
                .companySettlementDateYmd(companyApplySettlement.getCompanySettlementDateYmd())
                .companySettlementType(companyApplySettlement.getCompanySettlementType())
                .companySettlementAmount(companyApplySettlement.getCompanySettlementAmount())
                .companyApproval(companyApplySettlement.getCompanyApproval())
                .build();
    }
}
