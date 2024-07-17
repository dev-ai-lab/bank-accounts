package com.bank.accounts;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SchedulerRunner implements Runnable {

    @Override
    public void run() {
        // Task to be executed periodically
        System.out.println("Scheduler task executed!" + "at: " + LocalDateTime.now());
    }
}