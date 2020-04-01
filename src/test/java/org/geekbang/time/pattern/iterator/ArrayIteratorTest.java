package org.geekbang.time.pattern.iterator;

import org.junit.Test;

import java.util.ArrayList;

public class ArrayIteratorTest {

    @Test
    public void test() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("A");
        strings.add("B");
        strings.add("C");
        strings.add("D");

        ArrayIterator<String> iterator = new ArrayIterator<>(strings);
        while (iterator.hasNext()) {
            String currentItem = iterator.currentItem();
            System.out.println(currentItem);
            iterator.next();
        }
    }

}