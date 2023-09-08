package com.woorinpang.settlementservice.application.settlement.api.payment.v1;

import com.woorinpang.settlementservice.application.settlement.api.payment.v1.request.AddPaymentRecordRequest;
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

    @PostMapping("/{transactionId}")
    public ResponseEntity addPaymentRecord(
            @PathVariable String transactionId,
            @RequestBody @Valid AddPaymentRecordRequest request
    ) {

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
