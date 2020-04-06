package org.geekbang.time.pattern.iterator;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class SnapshotArrayIteratorTest {

    private ArrayList<String> list;

    @Before
    public void createList() {
        list = new ArrayList<>(Arrays.asList("3", "8", "2"));
    }
    
    @Test
    public void test() {
        SnapshotArrayIterator<String> iterator1 = new SnapshotArrayIterator<>(list);
        list.remove("2");
        SnapshotArrayIterator<String> iterator2 = new SnapshotArrayIterator<>(list);
        list.remove("3");
        SnapshotArrayIterator<String> iterator3 = new SnapshotArrayIterator<>(list);

        printIterator(iterator1);
        printIterator(iterator2);
        printIterator(iterator3);
    }

    private void printIterator(SnapshotArrayIterator<String> iterator) {
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

}