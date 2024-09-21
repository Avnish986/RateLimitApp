package com.test2;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        RateLimiterConfiguration config = new FixedWindowRateLimiterConfiguration(5, 60000);
        RateLimiter rateLimiter = new FixedWindowRateLimiter(config);
        RequestHandler requestHandler = new RateLimitedRequestHandler(rateLimiter);

        String clientId = "client1";

        for (int i = 0; i < 10; i++) {
            requestHandler.handleRequest(clientId);
        }
    }
}