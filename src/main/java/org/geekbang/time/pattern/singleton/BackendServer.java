package org.geekbang.time.pattern.singleton;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BackendServer {

    private long serverNo;
    private String serverAddress;

    private static final int SERVER_COUNT = 3;
    private static final Map<Long, BackendServer> serverInstances = new HashMap<>();

    static {
        serverInstances.put(1L, new BackendServer(1L, "192.134.22.138:8080"));
        serverInstances.put(2L, new BackendServer(2L, "192.134.22.139:8080"));
        serverInstances.put(3L, new BackendServer(3L, "192.134.22.140:8080"));
    }

    private BackendServer(long serverNo, String serverAddress) {
        this.serverNo = serverNo;
        this.serverAddress = serverAddress;
    }

    public static BackendServer getInstance(long serverNo) {
        return serverInstances.get(serverNo);
    }

    public static BackendServer getRadomInstance() {
        Random r = new Random();
        int no = r.nextInt(SERVER_COUNT)+1;
        return serverInstances.get(no);
    }

}
