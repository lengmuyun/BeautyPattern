package org.geekbang.time.pattern.singleton;

import org.junit.Test;

import static org.junit.Assert.*;

public class ThreadLocalIdGeneratorTest {

    @Test
    public void getInstanceInSingleThread() {
        ThreadIdGenerator instance1 = ThreadLocalIdGenerator.getInstance();
        ThreadIdGenerator instance2 = ThreadLocalIdGenerator.getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    public void getInstanceInMultiThread() throws InterruptedException {
        ThreadIdGenerator instance1 = ThreadLocalIdGenerator.getInstance();

        ThreadIdGenerator[] instance2 = new ThreadIdGenerator[1];
        Thread thread = new Thread(() -> instance2[0] = ThreadLocalIdGenerator.getInstance());
        thread.start();
        thread.join();

        assertNotSame(instance1, instance2[0]);
    }

}