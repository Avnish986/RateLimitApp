package com.test2;

public class FixedWindowRateLimiterConfiguration implements RateLimiterConfiguration {

    private final int allowedRequests;
    private final long timeWindowInMillis;

    public FixedWindowRateLimiterConfiguration(int allowedRequests, long timeWindowInMillis) {
        this.allowedRequests = allowedRequests;
        this.timeWindowInMillis = timeWindowInMillis;
    }

    @Override
    public int getAllowedRequests() {
        return allowedRequests;
    }

    @Override
    public long getTimeWindowInMillis() {
        return timeWindowInMillis;
    }
}
