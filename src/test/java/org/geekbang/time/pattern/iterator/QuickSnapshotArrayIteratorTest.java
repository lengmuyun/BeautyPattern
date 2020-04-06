package org.geekbang.time.pattern.iterator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
        QuickSnapshotArrayIterator<String> iterator1 = new QuickSnapshotArrayIterator<>(list);
        assertEquals(0, iterator1.getCursorInAll());

        printIterator(iterator1);

        list.remove("3");
        QuickSnapshotArrayIterator<String> iterator2 = new QuickSnapshotArrayIterator<>(list);
        assertEquals(1, iterator2.getCursorInAll());
        printIterator(iterator2);

        list.remove("3");
        QuickSnapshotArrayIterator<String> iterator3 = new QuickSnapshotArrayIterator<>(list);
        printIterator(iterator3);
    }

    private void printIterator(Iterator<String> iterator) {
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

}