package com.woorinpang.settlementservice.application.settlement.api.payment.v1.request;

import com.woorinpang.settlementservice.application.settlement.api.global.exception.FieldError;
import com.woorinpang.settlementservice.application.settlement.api.global.exception.JsonInvalidRequestException;
import com.woorinpang.settlementservice.application.settlement.api.global.exception.SettlementApiException;
import com.woorinpang.settlementservice.common.objects.Amount;
import com.woorinpang.settlementservice.common.objects.YearMonthDay;
import com.woorinpang.settlementservice.domain.payment.domain.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class AddPaymentRecordRequest {
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

    public void validate() {
        List<FieldError> errors = new ArrayList();

        if (this.userName.contains("바보")) {
            errors.add(new FieldError("userName", this.userName, "유저명은 나쁜말을 사용할 수 없습니다."));
        }

        if (errors.size() > 0) {
            throw new SettlementApiException(errors);
        }
    }

    public Company toCompany() {
        return new Company(this.companyId, this.companyName);
    }

    public Store toStore() {
        return new Store(this.storeId, this.storeName);
    }

    public User toUser() {
        return new User(this.userId, this.userName);
    }

    public PaymentAmount toPaymentAmount() {
        return PaymentAmount.builder()
                .paymentAmount(Amount.create(this.paymentAmount))
                .companySettlementAmount(Amount.create(this.companySettlementAmount))
                .storeSettlementAmount(Amount.create(this.storeSettlementAmount))
                .build();
    }

    public PaymentDay toPaymentDay() {
        LocalDateTime now = LocalDateTime.now();
        return PaymentDay.builder()
                .paymentDate(now)
                .paymentDateYmd(YearMonthDay.of(now))
                .build();
    }
}
