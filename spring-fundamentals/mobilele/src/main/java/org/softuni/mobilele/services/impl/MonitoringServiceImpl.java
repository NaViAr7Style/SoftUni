package org.softuni.mobilele.services.impl;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.softuni.mobilele.services.MonitoringService;
import org.springframework.stereotype.Service;

@Service
public class MonitoringServiceImpl implements MonitoringService {

    private Counter offerSearches;

    public MonitoringServiceImpl(MeterRegistry meterRegistry) {
        offerSearches = Counter
                .builder("offer_search_count")
                .description("How many offer searches we have performed")
                .register(meterRegistry);
    }

    @Override
    public void logOfferSearch() {
        offerSearches.increment();
    }
}
