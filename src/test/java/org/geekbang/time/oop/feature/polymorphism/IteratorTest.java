package org.geekbang.time.oop.feature.polymorphism;

import org.junit.Test;

public class IteratorTest {
    
    @Test
    public void testArray() {
        Array<String> array = new Array<>(10);
        array.add("A");
        array.add("B");
        array.add("C");
        print(array);
    }

    @Test
    public void testLinkedList() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        print(linkedList);
    }

    public void print(Iterator iterator) {
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}