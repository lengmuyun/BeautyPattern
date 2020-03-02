package org.geekbang.time.pattern.adapter.example;

public class Adaptee {

    public void fa() {
        print("fa");
    }

    public void fb() {
        print("fb");
    }

    public void fc() {
        print("fc");
    }

    private void print(String functionName) {
        System.out.println("method " + functionName + " invoked.");
    }

}
