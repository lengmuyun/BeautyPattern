package org.geekbang.time.pattern.iterator;

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
        moveToFirst();
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

    public int getCursorInAll() {
        return cursorInAll;
    }

    private void moveToFirst() {
        justMove(true);
    }

    private void justNext() {
        justMove(false);
    }

    private void justMove(boolean moveToFirst) {
        while (cursorInAll < arrayList.getTotalSize()) {
            if (arrayList.isExists(cursorInAll, snapshotTimestamp)) {
                leftCount--;
                if (!moveToFirst) {
                    cursorInAll++;
                }
                break;
            }
            cursorInAll++;
        }
    }

}
