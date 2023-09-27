package com.sixheadword.gappa.config.Batch;

import com.sixheadword.gappa.loan.Loan;
import com.sixheadword.gappa.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class ItemWriterConfig {

    @Bean
    public ItemWriter<Loan> afterPeriodLoanWriter() {

        return null;
    }

    @Bean
    public ItemWriter<Loan> beforePeriodLoanWriter() {
        return null;
    }

    @Bean
    public ItemWriter<User> inactiveUserWriter() {
        return null;
    }

}
