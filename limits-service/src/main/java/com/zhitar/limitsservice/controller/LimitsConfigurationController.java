package com.zhitar.limitsservice.controller;

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
}
