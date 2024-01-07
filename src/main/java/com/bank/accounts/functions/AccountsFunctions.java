package com.bank.accounts.functions;

import com.bank.accounts.service.IAccountsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

/**
 * This function will consume message send from bank-messaging-service to the exchange.
 * At its core, it is just a method with Java functional interface capabilities.
 */
@Configuration
public class AccountsFunctions {

    private static final Logger log = LoggerFactory.getLogger(AccountsFunctions.class);

    @Bean
    public Consumer<Long> ackCommunication(IAccountsService accountsService) {
        return accountNumber -> {
            log.info("Acknowledging Communication status for the account number : " + accountNumber.toString());
            accountsService.updateCommunicationStatus(accountNumber);
        };
    }

}
