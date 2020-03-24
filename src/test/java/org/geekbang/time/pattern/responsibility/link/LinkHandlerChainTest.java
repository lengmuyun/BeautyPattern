package org.geekbang.time.pattern.responsibility.link;

import org.junit.Test;

public class LinkHandlerChainTest {

    @Test
    public void test() {
        LinkHandlerChain handlerChain = new LinkHandlerChain();
        handlerChain.addHandler(new Handler() {
            @Override
            protected boolean doHandle() {
                System.out.println("handler A invoked.");
                return false;
            }
        });
        handlerChain.addHandler(new Handler() {
            @Override
            protected boolean doHandle() {
                System.out.println("handler B invoked.");
                return false;
            }
        });
        handlerChain.handle();
    }

}