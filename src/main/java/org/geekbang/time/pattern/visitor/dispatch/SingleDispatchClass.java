package org.geekbang.time.pattern.visitor.dispatch;

public class SingleDispatchClass {

    public void polymorphismFunction(ParentClass p) {
        p.f();
    }

    public void overloadFunction(ParentClass p) {
        p.f();
//        System.out.println("I am overloadFunction(ParentClass p).");
    }

    public void overloadFunction(ChildClass c) {
        c.f();
//        System.out.println("I am overloadFunction(ChildClass c).");
    }

}
