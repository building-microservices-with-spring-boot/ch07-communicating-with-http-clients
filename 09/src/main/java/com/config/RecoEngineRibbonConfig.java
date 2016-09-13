package com.config;

import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import org.springframework.context.annotation.Bean;

public class RecoEngineRibbonConfig {

    @Bean
    public IPing ribbonPing() {
        PingUrl pingUrl = new PingUrl();
        pingUrl.setPingAppendString("/health");
        return pingUrl;
    }

    @Bean
    public IRule ribbonRule() {
        return new AvailabilityFilteringRule();
    }
}
