package org.geekbang.time.pattern.callback;

public class AClass {

    public static void main(String[] args) {
        BClass b = new BClass();
        b.process(() -> System.out.println("Call back me."));
    }

}
