package org.geekbang.time.pattern.singleton;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MapIdGenerator implements ThreadIdGenerator {

    private AtomicLong id = new AtomicLong(0);
    private static final ConcurrentHashMap<Long, ThreadIdGenerator> instances = new ConcurrentHashMap<>();

    private MapIdGenerator() {
    }

    public static synchronized ThreadIdGenerator getInstance() {
        final long currentThreadId = Thread.currentThread().getId();
        if (!instances.containsKey(currentThreadId)) {
            instances.put(currentThreadId, new MapIdGenerator());
        }
        return instances.get(currentThreadId);
    }

    public Long getId() {
        return id.incrementAndGet();
    }

}
