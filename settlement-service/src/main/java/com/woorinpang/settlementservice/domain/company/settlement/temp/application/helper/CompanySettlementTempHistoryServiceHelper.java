package com.woorinpang.settlementservice.domain.company.settlement.temp.application.helper;

import com.woorinpang.settlementservice.domain.company.settlement.temp.domain.CompanySettlementTemp;
import com.woorinpang.settlementservice.domain.company.settlement.temp.application.exception.CompanySettlementTempHistoryNotFoundException;
import com.woorinpang.settlementservice.domain.company.settlement.temp.domain.history.CompanySettlementTempHistory;
import com.woorinpang.settlementservice.domain.company.settlement.temp.domain.history.CompanySettlementTempHistoryRepository;

public final class CompanySettlementTempHistoryServiceHelper {
    /**
     * 컴퍼니 정산임시기록 단건조회
     */
    public static CompanySettlementTempHistory findCompanySettlementTempById(CompanySettlementTempHistoryRepository companySettlementTempHistoryRepository,
                                                                             Long companySettlementTempHistoryId) {
        return companySettlementTempHistoryRepository.findById(companySettlementTempHistoryId)
                .orElseThrow(() -> new CompanySettlementTempHistoryNotFoundException(companySettlementTempHistoryId));
    }

    /**
     * 컴퍼니 정산임시기록 저장
     */
    public static CompanySettlementTempHistory saveCompanySettlementTempHistory(CompanySettlementTempHistoryRepository companySettlementTempHistoryRepository,
                                                                                CompanySettlementTemp companySettlementTemp) {
        return companySettlementTempHistoryRepository.save(getCompanySettlementTempHistory(companySettlementTemp));
    }

    private static CompanySettlementTempHistory getCompanySettlementTempHistory(CompanySettlementTemp companySettlementTemp) {
        return CompanySettlementTempHistory.createCompanySettlementTempHistory()
                .companySettlementTemp(companySettlementTemp)
                .companyId(companySettlementTemp.getCompanyId())
                .companySettlementDateYmd(companySettlementTemp.getCompanySettlementDateYmd())
                .companySettlementTempAmount(companySettlementTemp.getCompanySettlementTempAmount())
                .companySettlementTempApply(companySettlementTemp.getCompanySettlementTempApply())
                .build();
    }
}
