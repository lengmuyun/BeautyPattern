package org.geekbang.time.pattern.prototype;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 任何时刻，系统 A 中的所有数据都必须是同一个版本的，要么都是版本 a，要么都是版本 b，不能有的是版本 a，有的是版本 b。
 * 在更新内存数据的时候，系统 A 不能处于不可用状态，也就是不能停机更新数据。
 */
public class SearchWordCacheUpgradeOne extends AbstractSearchWordCache {

    /**
     * 一次性从数据库加载最新数据，然后替换
     */
    @Override
    public void refresh() {
        List<SearchWord> allSearchWords = repository.getAllSearchWords();
        Map<String, SearchWord> newCurrentKeywords = new HashMap<>();
        allSearchWords.forEach(searchWord -> newCurrentKeywords.put(searchWord.getKeyword(), searchWord));
        currentKeywords = newCurrentKeywords;
    }

    @Override
    public SearchWord get(String key) {
        return currentKeywords.get(key);
    }

}
