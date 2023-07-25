package com.woorinpang.settlementservice.domain.company.settlement.apply.application.helper;

import com.woorinpang.settlementservice.domain.company.settlement.apply.domain.CompanySettlementApply;
import com.woorinpang.settlementservice.domain.company.settlement.apply.application.exception.CompanySettlementApplyHistoryNotFoundException;
import com.woorinpang.settlementservice.domain.company.settlement.apply.domain.history.CompanySettlementApplyHistory;
import com.woorinpang.settlementservice.domain.company.settlement.apply.domain.history.CompanySettlementApplyHistoryRepository;

public final class CompanySettlementApplyHistoryServiceHelper {
    /**
     * 컴퍼니 정산반영기록 단건 조회
     */
    public static CompanySettlementApplyHistory findCompanySettlementApplyHistoryById(CompanySettlementApplyHistoryRepository companySettlementApplyHistoryRepository,
                                                                                      Long companySettlementApplyHistoryId) {
        return companySettlementApplyHistoryRepository.findById(companySettlementApplyHistoryId)
                .orElseThrow(() -> new CompanySettlementApplyHistoryNotFoundException(companySettlementApplyHistoryId));
    }

    /**
     * 컴퍼니 정산반영기록 저장
     */
    public static CompanySettlementApplyHistory saveCompanySettlementApplyHistory(CompanySettlementApplyHistoryRepository companySettlementApplyHistoryRepository,
                                                                                  CompanySettlementApply companySettlementApply) {
        return companySettlementApplyHistoryRepository.save(getCompanySettlementApplyHistory(companySettlementApply));
    }

    private static CompanySettlementApplyHistory getCompanySettlementApplyHistory(CompanySettlementApply companySettlementApply) {
        return CompanySettlementApplyHistory.createCompanySettlementApplyHistory()
                .companySettlementApply(companySettlementApply)
                .companySettlementDateYmd(companySettlementApply.getCompanySettlementDateYmd())
                .companySettlementType(companySettlementApply.getCompanySettlementType())
                .settlementApplyAmount(companySettlementApply.getCompanySettlementApplyAmount())
                .companyApproval(companySettlementApply.getCompanyApproval())
                .build();
    }
}