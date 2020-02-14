package org.geekbang.time.pattern.singleton;

import org.junit.Test;

import static org.junit.Assert.*;

public class MapIdGeneratorTest {

    @Test
    public void getInstanceInSingleThread() {
        ThreadIdGenerator instance1 = MapIdGenerator.getInstance();
        ThreadIdGenerator instance2 = MapIdGenerator.getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    public void getInstanceInMultiThread() throws InterruptedException {
        ThreadIdGenerator instance1 = MapIdGenerator.getInstance();

        ThreadIdGenerator[] instance2 = new ThreadIdGenerator[1];
        Thread thread = new Thread(() -> instance2[0] = MapIdGenerator.getInstance());
        thread.start();
        thread.join();

        assertNotSame(instance1, instance2[0]);
    }

}