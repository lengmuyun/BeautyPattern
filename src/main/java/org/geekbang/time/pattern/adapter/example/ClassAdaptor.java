package org.geekbang.time.pattern.adapter.example;

/**
 * 类适配器，基于继承
 * 接口中的同名方法可以不实现
 */
public class ClassAdaptor extends Adaptee implements ITarget {

    @Override
    public void f1() {
        this.fa();
    }

    @Override
    public void f2() {
        this.fb();
    }

}
