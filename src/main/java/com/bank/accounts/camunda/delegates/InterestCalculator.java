package com.bank.accounts.camunda.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class InterestCalculator implements JavaDelegate {
    private static final Logger LOGGER = LoggerFactory.getLogger(InterestCalculator.class);

    @Override
    public void execute(DelegateExecution execution) {
        LOGGER.info("calculating interest of the loan");
    }
}
