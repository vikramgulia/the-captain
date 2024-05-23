package com.captain.config;

import com.codahale.metrics.JmxReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Metrics {

    static final MetricRegistry registry = new MetricRegistry();

    public Metrics() {
        final JmxReporter reporter = JmxReporter.forRegistry(registry).build();
        reporter.start();
    }

    private final Map<String, Timer> timers = new HashMap<>();

    public Timer timer(String name) {
        if (timers.containsKey(name)) {
            return timers.get(name);
        } else {
            final Timer timer = registry.timer(name);
            timers.put(name, timer);
            return timer;
        }
    }
}