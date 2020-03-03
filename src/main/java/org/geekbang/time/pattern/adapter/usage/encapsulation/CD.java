package org.geekbang.time.pattern.adapter.usage.encapsulation;

/**
 * 这个类来自外部sdk，我们无权修改他的代码
 */
public class CD {

    public static void staticFunction1() {
        print("staticFunction1");
    }

    public void uglgNamingFunction2() {
        print("uglgNamingFunction2");
    }

    public void tooManyParamsFunction3(int paramA, int paramB) {
        print("tooManyParamsFunction3");
    }

    public void lowPerformanceFunction4() {
        print("lowPerformanceFunction4");
    }

    private static void print(String methodName) {
        System.out.println("method " + methodName + " invoked.");
    }

}
