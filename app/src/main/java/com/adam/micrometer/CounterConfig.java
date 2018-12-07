package com.adam.micrometer;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CounterConfig {

    private final MeterRegistry meterRegistry;

    @Autowired
    public CounterConfig(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @Bean
    public Counter counter(){
        return meterRegistry.counter("custom-counter");
    }

    @Bean
    public Timer timer(){
        return meterRegistry.timer("custom-timer");
    }
}
