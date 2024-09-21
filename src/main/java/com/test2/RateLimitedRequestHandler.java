package com.test2;

public class RateLimitedRequestHandler implements RequestHandler{

    private final RateLimiter rateLimiter;

    public RateLimitedRequestHandler(RateLimiter rateLimiter) {
        this.rateLimiter = rateLimiter;
    }

    @Override
    public void handleRequest(String clientId) {
        if (rateLimiter.isRequestAllowed(clientId)) {
            System.out.println("Request processed for client: " + clientId);
        } else {
            System.out.println("Rate limit exceeded for client: " + clientId);
        }
    }
}
