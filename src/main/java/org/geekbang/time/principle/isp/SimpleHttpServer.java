package org.geekbang.time.principle.isp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleHttpServer {

    private String host;
    private int port;
    private Map<String, List<Viewer>> viewers = new HashMap<>();

    public SimpleHttpServer(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void addViewers(String urlDirectory, Viewer viewer) {
        if (!viewers.containsKey(urlDirectory)) {
            viewers.put(urlDirectory, new ArrayList<>());
        }
        this.viewers.get(urlDirectory).add(viewer);
    }

    public void run() {

    }

}
