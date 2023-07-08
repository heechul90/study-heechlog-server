package com.woorinpang.settlementservice.domain.payment.record.original.presentation.dto.request;

import com.woorinpang.settlementservice.domain.payment.record.common.domain.PaymentAmount;
import com.woorinpang.settlementservice.domain.payment.record.original.application.dto.command.SavePaymentOriginalRecordCommand;
import com.woorinpang.settlementservice.domain.payment.record.original.domain.*;
import com.woorinpang.settlementservice.global.common.entity.Amount;
import com.woorinpang.settlementservice.global.common.entity.YearMonthDay;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AddPaymentOriginalRecordRequest {
    private Long companyId;
    private String companyName;
    private Long storeId;
    private String storeName;
    private Long userId;
    private String userName;
    private Long userPayAmount;
    private Long mypointPayAmount;
    private Long instantPayAmount;
    private Long mealAmount;
    private Long couponAmount;
    private Long companySettlementAmount;
    private Long storeSettlementAmount;
    private LocalDateTime paymentDate;
    private LocalDateTime paymentCancellationDate;
    private String paymentCancellationReason;
    private String paymentType;

    public void validate() {

    }

    public SavePaymentOriginalRecordCommand toCommand(String transactionId) {
        return SavePaymentOriginalRecordCommand.builder()
                .transactionId(transactionId)
                .company(new Company(this.companyId, this.companyName))
                .store(new Store(this.storeId, this.storeName))
                .user(new User(this.userId, this.userName))
                .paymentAmount(
                        PaymentAmount.builder()
                                .userPayAmount(new Amount(this.userPayAmount))
                                .mypointPayAmount(new Amount(this.mypointPayAmount == null ? 0L : this.mypointPayAmount))
                                .instantPayAmount(new Amount(this.instantPayAmount == null ? 0L : this.instantPayAmount))
                                .mealAmount(new Amount(this.mealAmount == null ? 0L : this.mealAmount))
                                .couponAmount(new Amount(this.couponAmount == null ? 0L : this.couponAmount))
                                .companySettlementAmount(new Amount(this.companySettlementAmount))
                                .storeSettlementAmount(new Amount(this.storeSettlementAmount))
                                .build()
                )
                .payment(new Payment(this.paymentDate, YearMonthDay.of(this.paymentDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")))))
                .paymentCancellation(new PaymentCancellation(
                        this.paymentCancellationDate,
                        YearMonthDay.of(this.paymentCancellationDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"))),
                        this.paymentCancellationReason)
                )
                .paymentType(PaymentType.findByCode(this.paymentType))
                .build();
    }
}
