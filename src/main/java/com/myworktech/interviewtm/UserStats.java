package com.myworktech.interviewtm;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class UserStats {
    private final Map<String, AtomicLong> hitsPerUser = new ConcurrentHashMap<>();

    public void onUserCall(String userId) {
        AtomicLong value = hitsPerUser.get(userId);
        if (value == null) {
            value = new AtomicLong(0L);
            AtomicLong previous = hitsPerUser.putIfAbsent(userId, value);
            value = previous != null ? previous : value;
        }
        value.getAndIncrement();
    }
}
