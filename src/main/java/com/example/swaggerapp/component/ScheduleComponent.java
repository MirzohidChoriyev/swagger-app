package com.example.swaggerapp.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScheduleComponent {

    //@Scheduled(fixedRate = 1000, initialDelay = 1000)
    public void scheduledTestInsert() throws InterruptedException{
        System.out.println(new Date());
    }

}
