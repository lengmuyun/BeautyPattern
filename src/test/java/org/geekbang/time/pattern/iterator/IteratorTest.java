package org.geekbang.time.pattern.iterator;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorTest {

    private List<String> list;

    @Before
    public void createList() {
        list = Arrays.asList("A", "B", "C", "D");
    }

    @Test
    public void testRemove() {
        List<String> strings = new ArrayList<>(list);
        Iterator<String> iterator = strings.iterator();

        System.out.println(iterator.next());
        iterator.remove();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test(expected = ConcurrentModificationException.class)
    public void testDoubleRemove() {
        List<String> names = new ArrayList<>(list);
        testIteratorRemove(names);
    }

    @Test(expected = ConcurrentModificationException.class)
    public void testLinkedDoubleRemove() {
        List<String> names = new LinkedList<>(list);
        testIteratorRemove(names);
    }

    private void testIteratorRemove(List<String> names) {
        Iterator<String> iterator1 = names.iterator();
        Iterator<String> iterator2 = names.iterator();
        iterator1.next();
        iterator1.remove();
        iterator2.next(); // 运行结果？
    }

}