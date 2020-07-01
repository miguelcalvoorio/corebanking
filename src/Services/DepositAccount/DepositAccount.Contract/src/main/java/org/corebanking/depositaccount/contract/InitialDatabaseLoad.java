package org.corebanking.depositaccount.contract;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class InitialDatabaseLoad {

    @Bean
    CommandLineRunner initDatabase(final ContractRepository contractRepository) {
        return args -> {
            log.info("Preloading... " +  contractRepository.save(new Contract(
                "ES000100010100000001",
                "001001",
                "OPEN",
                "20200101100000",
                "20200601100000")));
            log.info("Preloading... " +  contractRepository.save(new Contract(
                "ES000100010100000002",
                "001002",
                "OPEN",
                "20200101111000",
                "20200601111000")));
            log.info("Preloading... " +  contractRepository.save(new Contract(
                "ES000100010100000003",
                "001001",
                "LOCK",
                "20200101112000",
                "20200601112000")));
        };
    }
}