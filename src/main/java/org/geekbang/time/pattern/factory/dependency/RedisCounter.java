package org.geekbang.time.pattern.factory.dependency;

public class RedisCounter {

    private String ipAddress;
    private int port;

    public RedisCounter(String ipAddress, int port) {
        this.ipAddress = ipAddress;
        this.port = port;
    }

}
