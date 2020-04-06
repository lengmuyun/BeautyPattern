package org.geekbang.time.pattern.iterator;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class QuickSnapshotArrayIteratorTest {

    private ArrayList<String> list;

    @Before
    public void createList() {
        list = new ArrayList<>();
        list.add("3");
        list.add("8");
        list.add("2");
    }

    @Test
    public void test() {
        final String s = list.toString();
        System.out.println(s);

        QuickSnapshotArrayIterator<String> iterator1 = new QuickSnapshotArrayIterator<>(list);
        printIterator(iterator1);

//        list.remove("2");
//        QuickSnapshotArrayIterator<String> iterator2 = new QuickSnapshotArrayIterator<>(list);
//        printIterator(iterator2);
//
//        list.remove("3");
//        QuickSnapshotArrayIterator<String> iterator3 = new QuickSnapshotArrayIterator<>(list);
//        printIterator(iterator3);
    }

    private void printIterator(Iterator<String> iterator) {
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

}