package com.club.controller;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Service;

@Service
public class AccessLimitService {
    RateLimiter rateLimiter = RateLimiter.create(5.0);

    public boolean tryAcquire(){
        return rateLimiter.tryAcquire();
    }
}
