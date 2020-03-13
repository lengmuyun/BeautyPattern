package org.geekbang.time.pattern.observer.usage;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.Executors;

public class EventBusTest {

    private EventBus eventBus;

    @Before
    public void initializeEventBus() {
        eventBus = new AsyncEventBus(Executors.newFixedThreadPool(2));
        eventBus.register(new NotificationObserver());
    }

    @Test
    public void test() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "-" + thread.getId() + " test method invoked.");
        eventBus.post("This is a message.");
    }

    public class NotificationObserver {

        @Subscribe
        public void sendMessage(String message) {
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName() + "-" + thread.getId() + " receive a message: " + message);
        }

    }

}