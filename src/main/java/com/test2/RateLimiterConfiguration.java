package com.test2;

public interface RateLimiterConfiguration {
    int getAllowedRequests();
    long getTimeWindowInMillis();
}
