package org.geekbang.time.pattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

public class ThreadLocalIdGenerator implements ThreadIdGenerator {

    private AtomicLong id = new AtomicLong(0);
    private static ThreadLocal<ThreadLocalIdGenerator> instance = ThreadLocal.withInitial(ThreadLocalIdGenerator::new);

    public static ThreadIdGenerator getInstance() {
        return instance.get();
    }

    public Long getId() {
        return id.incrementAndGet();
    }

}
