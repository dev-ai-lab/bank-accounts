package com.bank.accounts;

import jakarta.annotation.PostConstruct;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.Date;

/*@Component
public class ScheduledTask {

    public void runTask(int newInterval) {

        System.out.println("Scheduled task executed at: " + new Date() + " with interval: " + newInterval + " milliseconds");
    }
}*/

@Service
public class ScheduledTask {
    @Value("${scheduler.interval}")
    private long interval;

    private ThreadPoolTaskScheduler taskScheduler;

    private Runnable task;



    @PostConstruct
    public void init() {
        taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.initialize();
        task = () -> {
            System.out.println("Scheduled new task executed at: " + new Date() + " with interval: " + interval + " milliseconds");
        };
        rescheduleTask(interval);
    }

    public void rescheduleTask(long interval) {
        taskScheduler.schedule(task, new CronTrigger(String.format("*/%d * * * * *", interval/1000)));
    }
    public void setInterval(long interval) {
        this.interval = interval;
        rescheduleTask(interval);
    }
}
