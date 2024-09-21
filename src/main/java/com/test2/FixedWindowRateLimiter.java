package com.test2;

import java.util.HashMap;
import java.util.Map;

public class FixedWindowRateLimiter implements RateLimiter {

    private final Map<String, Integer> requestCounts = new HashMap<>();
    private final Map<String, Long> timeStamps = new HashMap<>();
    private final RateLimiterConfiguration config;

    public FixedWindowRateLimiter(RateLimiterConfiguration config) {
        this.config = config;
    }

    @Override
    public boolean isRequestAllowed(String clientId) {
        long currentTime = System.currentTimeMillis();
        requestCounts.putIfAbsent(clientId, 0);
        timeStamps.putIfAbsent(clientId, currentTime);

        long timeElapsed = currentTime - timeStamps.get(clientId);

        if (timeElapsed > config.getTimeWindowInMillis()) {
            timeStamps.put(clientId, currentTime);
            requestCounts.put(clientId, 0);
        }

        if (requestCounts.get(clientId) < config.getAllowedRequests()) {
            requestCounts.put(clientId, requestCounts.get(clientId) + 1);
            return true;
        }

        return false;
    }
}
