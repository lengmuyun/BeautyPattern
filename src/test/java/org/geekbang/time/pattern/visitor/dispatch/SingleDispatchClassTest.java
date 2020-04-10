package org.geekbang.time.pattern.visitor.dispatch;

import org.junit.Test;

public class SingleDispatchClassTest {

    @Test
    public void test() {
        SingleDispatchClass demo = new SingleDispatchClass();
        ParentClass p = new ChildClass();
        demo.polymorphismFunction(p);//执行哪个对象的方法，由对象的实际类型决定
        demo.overloadFunction(p);//执行对象的哪个方法，由参数对象的声明类型决定
    }

}