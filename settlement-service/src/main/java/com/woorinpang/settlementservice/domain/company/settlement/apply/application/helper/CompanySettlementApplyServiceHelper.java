package com.woorinpang.settlementservice.domain.company.settlement.apply.application.helper;

import com.woorinpang.settlementservice.domain.company.settlement.apply.application.exception.CompanySettlementApplyNotFoundException;
import com.woorinpang.settlementservice.domain.company.settlement.apply.domain.CompanySettlementApply;
import com.woorinpang.settlementservice.domain.company.settlement.apply.domain.CompanySettlementApplyRepository;
import com.woorinpang.settlementservice.domain.company.settlement.apply.domain.history.CompanySettlementApplyHistoryRepository;

import static com.woorinpang.settlementservice.domain.company.settlement.apply.application.helper.CompanySettlementApplyHistoryServiceHelper.*;

public final class CompanySettlementApplyServiceHelper {
    /**
     * 컴퍼니 정산반영 단건조회
     */
    public CompanySettlementApply findCompanySettlementApplyById(CompanySettlementApplyRepository companySettlementApplyRepository,
                                                                 Long companySettlementApplyId) {
        return companySettlementApplyRepository.findById(companySettlementApplyId)
                .orElseThrow(() -> new CompanySettlementApplyNotFoundException(companySettlementApplyId));
    }

    /**
     * 컴퍼니 정산반영 저장
     */
    public CompanySettlementApply saveCompanySettlementApply(CompanySettlementApplyRepository companySettlementApplyRepository,
                                                             CompanySettlementApplyHistoryRepository companySettlementApplyHistoryRepository,
                                                             CompanySettlementApply companySettlementApply) {
        CompanySettlementApply savedCompanySettlementApply = companySettlementApplyRepository.save(companySettlementApply);

        //save companySettlementApply
        saveCompanySettlementApplyHistory(companySettlementApplyHistoryRepository, savedCompanySettlementApply);

        return savedCompanySettlementApply;
    }
}
