package org.geekbang.time.pattern.prototype;

public class SearchWord {

    private String keyword;
    private long count;
    private long lastUpdateTime;

    public SearchWord(String keyword, long count, long lastUpdateTime) {
        this.keyword = keyword;
        this.count = count;
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getKeyword() {
        return keyword;
    }

    public long getCount() {
        return count;
    }

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void increaseCount(long add) {
        this.count += add;
    }

    public void timeLate(long timeLate) {
        this.lastUpdateTime += timeLate;
    }

}
