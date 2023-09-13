package com.woorinpang.settlementservice.storage.main.db.global.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = {"com.woorinpang.settlementservice.storage.main.db"})
@EnableJpaRepositories(basePackages = {"com.woorinpang.settlementservice.storage.main.db"})
public class MainJpaConfig {
}
