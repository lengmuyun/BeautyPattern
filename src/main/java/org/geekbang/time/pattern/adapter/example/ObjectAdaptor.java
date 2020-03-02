package org.geekbang.time.pattern.adapter.example;

/**
 * 对象适配器，基于委托
 */
public class ObjectAdaptor implements ITarget {

    private Adaptee adaptee;

    public ObjectAdaptor(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void f1() {
        adaptee.fa();
    }

    @Override
    public void f2() {
        System.out.println("自行实现该方法");
    }

    @Override
    public void fc() {
        adaptee.fc();
    }

}
