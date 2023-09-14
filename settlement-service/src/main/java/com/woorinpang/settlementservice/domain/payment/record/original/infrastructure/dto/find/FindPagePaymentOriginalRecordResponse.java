package com.woorinpang.settlementservice.domain.payment.record.original.infrastructure.dto.find;

import com.querydsl.core.annotations.QueryProjection;
import com.woorinpang.settlementservice.domain.payment.common.entity.PaymentAmount;
import com.woorinpang.settlementservice.domain.payment.record.original.domain.Company;
import com.woorinpang.settlementservice.domain.payment.record.original.domain.Payment;
import com.woorinpang.settlementservice.domain.payment.record.original.domain.Store;
import com.woorinpang.settlementservice.domain.payment.record.original.domain.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FindPagePaymentOriginalRecordResponse {
    private Long paymentOriginalRecordId;
    private String transactionId;
    private Long companyId;
    private String companyName;
    private Long storeId;
    private String storeName;
    private Long userId;
    private String userName;
    private BigDecimal paymentAmount;
    private BigDecimal companySettlementAmount;
    private BigDecimal storeSettlementAmount;
    private LocalDateTime paymentDate;

    @QueryProjection
    public FindPagePaymentOriginalRecordResponse(Long paymentOriginalRecordId, String transactionId, Company company,
                                                 Store store, User user, PaymentAmount paymentAmount, Payment payment) {
        this.paymentOriginalRecordId = paymentOriginalRecordId;
        this.transactionId = transactionId;
        this.companyId = company.getCompanyId();
        this.companyName = company.getCompanyName();
        this.storeId = store.getStoreId();
        this.storeName = store.getStoreName();
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.paymentAmount = paymentAmount.getPaymentAmount().getAmount();
        this.companySettlementAmount = paymentAmount.getCompanySettlementAmount().getAmount();
        this.storeSettlementAmount = paymentAmount.getStoreSettlementAmount().getAmount();
        this.paymentDate = payment.getPaymentDate();
    }
}
