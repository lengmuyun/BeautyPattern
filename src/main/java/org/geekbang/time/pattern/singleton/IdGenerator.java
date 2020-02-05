package org.geekbang.time.pattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {

    private AtomicLong id = new AtomicLong(0);
    private static final IdGenerator instance = new IdGenerator();

    private IdGenerator() {
    }

    public static IdGenerator getInstance() {
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }

}
