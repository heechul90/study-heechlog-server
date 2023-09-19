package com.woorinpang.settlementservice.application.settlement.api.payment.v1;

import com.woorinpang.settlementservice.application.settlement.api.global.response.ApiResponse;
import com.woorinpang.settlementservice.application.settlement.api.payment.v1.request.AddPaymentRecordRequest;
import com.woorinpang.settlementservice.application.settlement.api.payment.v1.response.AddPaymentRecordResponse;
import com.woorinpang.settlementservice.domain.payment.domain.PaymentRecordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/payment/records")
public class PaymentController {
    private final PaymentRecordService paymentRecordService;

    @PostMapping("/{transactionId}")
    public ResponseEntity<ApiResponse<AddPaymentRecordResponse>> addPaymentRecord(
            @PathVariable String transactionId,
            @RequestBody @Valid AddPaymentRecordRequest request
    ) {
        //validate
        request.validate();

        Long addedId = this.paymentRecordService.add(transactionId, request.toCompany(), request.toStore(), request.toUser(), request.toPaymentAmount(), request.toPaymentDay());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success(new AddPaymentRecordResponse(addedId)));
    }
}
