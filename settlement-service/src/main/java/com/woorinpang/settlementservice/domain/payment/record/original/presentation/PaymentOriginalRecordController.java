package com.woorinpang.settlementservice.domain.payment.record.original.presentation;

import com.woorinpang.settlementservice.domain.payment.record.original.application.CreatePaymentOriginalRecordService;
import com.woorinpang.settlementservice.domain.payment.record.original.presentation.dto.request.AddPaymentOriginalRecordRequest;
import com.woorinpang.settlementservice.domain.payment.record.original.presentation.dto.response.AddPaymentOriginalRecordResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/payment/original/records")
public class PaymentOriginalRecordController {
    private final CreatePaymentOriginalRecordService createPaymentOriginalRecordService;

    /**
     * 결제 원본기록 등록
     */
    @PostMapping("/{transactionId}")
    public ResponseEntity<AddPaymentOriginalRecordResponse> addPaymentOriginalRecord(
            @PathVariable("transactionId") String transactionId,
            @RequestBody @Valid AddPaymentOriginalRecordRequest request) {

        //validate
        request.validate();

        Long savedId = createPaymentOriginalRecordService.create(request.toCommand(transactionId));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new AddPaymentOriginalRecordResponse(savedId));
    }
}
