/*
package com.bank.accounts.config;

import com.bank.accounts.ScheduledTask;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
@Getter
@Setter
public class SchedulerConfig {
    @Value("${scheduler.interval}")
    private int interval;
    private final ScheduledTask scheduledTask;

    public SchedulerConfig(ScheduledTask scheduledTask) {
        this.scheduledTask = scheduledTask;
    }

    //@Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        //taskRegistrar.addFixedRateTask(() -> scheduledTask.runTask(interval), Duration.ofMillis(interval));
    }



 */
/*   private String fixedRateString = "30000"; // Initial fixed rate, default 5 seconds

    @Autowired
    private SchedulerRunner schedulerRunner;
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addFixedRateTask(schedulerRunner, Long.parseLong(fixedRateString));
    }

    public void updateFixedRate(String newRate) {
        this.fixedRateString = newRate;
        configureTasks(new ScheduledTaskRegistrar());
    }*//*

}
*/
