package com.woorinpang.settlementservice.domain.company.settlement.temp.application.helper;

import com.woorinpang.settlementservice.domain.company.settlement.temp.application.exception.CompanySettlementTempNotFoundException;
import com.woorinpang.settlementservice.domain.company.settlement.temp.domain.CompanySettlementTemp;
import com.woorinpang.settlementservice.domain.company.settlement.temp.domain.CompanySettlementTempRepository;
import com.woorinpang.settlementservice.domain.company.settlement.temp.domain.history.CompanySettlementTempHistoryRepository;

import static com.woorinpang.settlementservice.domain.company.settlement.temp.application.helper.CompanySettlementTempHistoryServiceHelper.saveCompanySettlementTempHistory;

public final class CompanySettlementTempServiceHelper {
    /**
     * 컴퍼니 정산임시 단건조회
     */
    public CompanySettlementTemp findCompanySettlementTempById(CompanySettlementTempRepository companySettlementTempRepository,
                                                               Long companySettlementTempId) {
        return companySettlementTempRepository.findById(companySettlementTempId)
                .orElseThrow(() -> new CompanySettlementTempNotFoundException(companySettlementTempId));
    }

    /**
     * 컴퍼니 정산임시 저장
     */
    public CompanySettlementTemp saveCompanySettlementTemp(CompanySettlementTempRepository companySettlementTempRepository,
                                                           CompanySettlementTempHistoryRepository companySettlementTempHistoryRepository,
                                                           CompanySettlementTemp companySettlementTemp) {
        CompanySettlementTemp savedCompanySettlementTemp = companySettlementTempRepository.save(companySettlementTemp);

        //save companySettlementTempHistory
        saveCompanySettlementTempHistory(companySettlementTempHistoryRepository, savedCompanySettlementTemp);

        return savedCompanySettlementTemp;
    }
}
