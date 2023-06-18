package com.woorinpang.settlementservice.global.common.config.jpa;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@EnableJpaAuditing
@Configuration
public class JpaAuditingConfig implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        //TODO 사용자 정보를 가져와 넣어줘야함
        return Optional.of("admin");
    }
}
