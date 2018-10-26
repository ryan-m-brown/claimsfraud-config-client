package com.claimsfraud.controller;

import org.springframework.cloud.endpoint.RefreshEndpoint;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("unused")
public class Refresher {

    private RefreshEndpoint refreshEndpoint;

    public Refresher(RefreshEndpoint refreshEndpoint) {
        this.refreshEndpoint = refreshEndpoint;
    }

    @Scheduled(fixedDelay = 6000, initialDelay = 6000)
    public void refreshContextPeriodically() {
        refreshEndpoint.refresh();
    }
}