package org.geekbang.time.principle.ocp;

import java.util.ArrayList;
import java.util.List;

public class Alert {

    private List<AlertHandler> handlers = new ArrayList<>();

    public void addHandler(AlertHandler handler) {
        handlers.add(handler);
    }

    public void check(ApiStatInfo apiStatInfo) {
        handlers.forEach(handler -> handler.check(apiStatInfo));
    }
    
}
