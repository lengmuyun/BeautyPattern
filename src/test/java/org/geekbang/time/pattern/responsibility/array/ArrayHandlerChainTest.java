package org.geekbang.time.pattern.responsibility.array;

import org.junit.Test;

public class ArrayHandlerChainTest {

    @Test
    public void test() {
        ArrayHandlerChain handlerChain = new ArrayHandlerChain();
        handlerChain.addHandler(() -> {
            System.out.println("handler A invoked.");
            return false;
        });
        handlerChain.addHandler(() -> {
            System.out.println("handler B invoked.");
            return false;
        });
        handlerChain.handle();
    }

}