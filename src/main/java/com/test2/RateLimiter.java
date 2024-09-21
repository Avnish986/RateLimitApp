package com.test2;

public interface RateLimiter {
    boolean isRequestAllowed(String clientId);
}
