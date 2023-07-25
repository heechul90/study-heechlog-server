package com.woorinpang.settlementservice.domain.bank.information.platform.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 플랫폼 은행 정보
 */
@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlatformBankInformation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "platform_bank_information_id")
    private Long id;
}
