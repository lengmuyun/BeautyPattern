package org.geekbang.time.oop.feature.polymorphism;

import org.junit.Test;

public class DynamicArrayTest {

    @Test
    public void test() {
        DynamicArray array = new SortedDynamicArray();
        array.add(5);
        array.add(1);
        array.add(3);
        for (int i=0; i<array.size(); i++) {
            System.out.println(array.get(i));
        }
    }

}