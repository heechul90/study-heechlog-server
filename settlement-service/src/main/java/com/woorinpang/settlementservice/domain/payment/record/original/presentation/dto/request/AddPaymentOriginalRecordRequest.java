package com.woorinpang.settlementservice.domain.payment.record.original.presentation.dto.request;

import com.woorinpang.settlementservice.domain.payment.record.common.entity.PaymentAmount;
import com.woorinpang.settlementservice.domain.payment.record.original.application.dto.command.CreatePaymentOriginalRecordCommand;
import com.woorinpang.settlementservice.domain.payment.record.original.domain.*;
import com.woorinpang.settlementservice.global.common.entity.Amount;
import com.woorinpang.settlementservice.global.common.entity.YearMonthDay;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AddPaymentOriginalRecordRequest {
    @NotNull(message = "컴퍼니 고유번호는 필수입니다.")
    private Long companyId;

    @NotBlank(message = "컴퍼니명은 필수입니다.")
    private String companyName;

    @NotNull(message = "스토어 고유번호는 필수잆니다.")
    private Long storeId;

    @NotBlank(message = "스토어명은 필수입니다.")
    private String storeName;

    @NotNull(message = "사용자 고유번호는 필수입니다.")
    private Long userId;

    @NotBlank(message = "사용자명은 필수입니다.")
    private String userName;

    private BigDecimal paymentAmount;

    private BigDecimal companySettlementAmount;

    private BigDecimal storeSettlementAmount;

    private LocalDateTime paymentDate;

    private LocalDateTime paymentCancellationDate;

    private String paymentCancellationReason;

    private String paymentType;

    public void validate() {

    }

    public CreatePaymentOriginalRecordCommand toCommand(String transactionId) {
        return CreatePaymentOriginalRecordCommand.builder()
                .transactionId(transactionId)
                .company(new Company(this.companyId, this.companyName))
                .store(new Store(this.storeId, this.storeName))
                .user(new User(this.userId, this.userName))
                .paymentAmount(this.getPaymentAmount())
                .payment(this.getPayment())
                .paymentCancellation(this.getPaymentCancellation())
                .paymentType(PaymentType.findByCode(this.paymentType))
                .build();
    }

    private PaymentAmount getPaymentAmount() {
        return PaymentAmount.of(
                Amount.create(this.paymentAmount),
                Amount.create(this.companySettlementAmount),
                Amount.create(this.storeSettlementAmount)
        );
    }

    private Payment getPayment() {
        return PaymentType.findByCode(this.paymentType).equals(PaymentType.GENERAL)
                ? new Payment(this.paymentDate, YearMonthDay.of(this.paymentDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"))))
                : null;
    }

    private PaymentCancellation getPaymentCancellation() {
        return PaymentType.findByCode(this.paymentType).equals(PaymentType.CANCEL)
                ? PaymentCancellation.builder()
                .paymentCancellationDate(this.paymentCancellationDate)
                .paymentCancellationYmd(YearMonthDay.of(this.paymentCancellationDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"))))
                .paymentCancellationReason(this.paymentCancellationReason)
                .build()
                : null;
    }
}
