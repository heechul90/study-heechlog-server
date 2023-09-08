package com.woorinpang.settlementservice.application.settlement.api.global.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @GetMapping("/heath")
    public ResponseEntity<Object> health() {
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
