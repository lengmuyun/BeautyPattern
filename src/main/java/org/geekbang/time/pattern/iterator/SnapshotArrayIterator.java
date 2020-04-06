package org.geekbang.time.pattern.iterator;

import java.util.ArrayList;

public class SnapshotArrayIterator<E> extends ArrayIterator<E> {

    public SnapshotArrayIterator(ArrayList<E> list) {
        this.cursor = 0;
        this.arrayList = new ArrayList<>();
        this.arrayList.addAll(list);
    }
}
