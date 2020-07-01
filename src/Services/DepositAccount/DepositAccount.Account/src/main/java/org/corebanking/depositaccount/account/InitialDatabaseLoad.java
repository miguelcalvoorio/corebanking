package org.corebanking.depositaccount.account;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class InitialDatabaseLoad {

    @Bean
    CommandLineRunner initDatabase(final AccountBalanceRepository accountBalanceRepository) {
        return args -> {
            log.info("Preloading... " +  accountBalanceRepository.save(new AccountBalance(
                "ES000100010100000001",
                "001001",
                10000.0,
                10000.0,
                "20200601100000")));
            log.info("Preloading... " +  accountBalanceRepository.save(new AccountBalance(
                "ES000100010100000002",
                "001002",
                20000.0,
                20000.0,
                "2020060111000")));
            log.info("Preloading... " +  accountBalanceRepository.save(new AccountBalance(
                "ES000100010100000003",
                "001001",
                12000.0,
                12000.0,
                "2020060111000")));
        };
    }
}