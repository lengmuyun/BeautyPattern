package org.geekbang.time.pattern.iterator;

@Deprecated
public class QuickSnapshotArrayIterator<E> implements Iterator<E> {

    private long snapshotTimestamp;

    /** 在整个容器中的下标，而非快照中的下标 */
    private int cursorInAll;

    /** 快照中还有几个元素未被遍历 */
    private int leftCount;

    private ArrayList<E> arrayList;

    public QuickSnapshotArrayIterator(ArrayList<E> arrayList) {
        this.snapshotTimestamp = System.currentTimeMillis();
        this.cursorInAll = 0;
        this.leftCount = arrayList.getActualSize();
        this.arrayList = arrayList;

        // 先跳到这个迭代器快照的第一个元素
        justNext();
    }

    @Override
    public boolean hasNext() {
        return this.leftCount >= 0;
    }

    @Override
    public E next() {
        E e = arrayList.get(cursorInAll);
        justNext();
        return e;
    }

    private void justNext() {
        while (cursorInAll < arrayList.getTotalSize()) {
            long addTimestamp = arrayList.getAddTimestamp(cursorInAll);
            long delTimestamp = arrayList.getDelTimestamp(cursorInAll);
            if (snapshotTimestamp > addTimestamp && snapshotTimestamp < delTimestamp) {
                leftCount--;
                break;
            }
            cursorInAll++;
        }
    }

}
