package com.zhitar.limitsservice.model;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Component
@ConfigurationProperties("limits-service")
public class LimitsConfiguration {
    private int max;
    private int limit;

    public LimitsConfiguration(LimitsConfiguration lc) {
        Objects.requireNonNull(lc);
        this.max = lc.max;
        this.limit = lc.limit;
    }
}
