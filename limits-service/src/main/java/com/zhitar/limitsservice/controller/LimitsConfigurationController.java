package com.zhitar.limitsservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zhitar.limitsservice.model.LimitsConfiguration;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LimitsConfigurationController {

    private final LimitsConfiguration limitsConfiguration;

    @GetMapping("limits")
    public LimitsConfiguration retrieveLimitsFromConfiguration() {
        return new LimitsConfiguration(limitsConfiguration);
    }

    @GetMapping("fault-tolerance-example")
    @HystrixCommand(fallbackMethod = "fallbackRetrieveConfiguration")
    public LimitsConfiguration retrieveConfiguration() {
        throw new RuntimeException("Not available");
    }

    public LimitsConfiguration fallbackRetrieveConfiguration() {
        return new LimitsConfiguration(50, 2);
    }
}
