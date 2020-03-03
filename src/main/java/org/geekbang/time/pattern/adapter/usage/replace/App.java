package org.geekbang.time.pattern.adapter.usage.replace;

public class App {

    public static void main(String[] args) {
//        Demo d = new Demo(new A());
        Demo d = new Demo(new BAdaptor(new B()));
    }
}
