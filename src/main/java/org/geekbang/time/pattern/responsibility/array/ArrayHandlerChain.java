package org.geekbang.time.pattern.responsibility.array;

import java.util.ArrayList;
import java.util.List;

public class ArrayHandlerChain {

    private List<IHandler> handlers = new ArrayList<>();

    public void addHandler(IHandler handler) {
        this.handlers.add(handler);
    }

    public void handle() {
        for (IHandler handler : handlers) {
            boolean handled = handler.handle();
            if (handled) break;
        }
    }
}
