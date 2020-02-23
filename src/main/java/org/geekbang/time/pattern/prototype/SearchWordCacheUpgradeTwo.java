package org.geekbang.time.pattern.prototype;

import java.util.HashMap;
import java.util.List;

public class SearchWordCacheUpgradeTwo extends AbstractSearchWordCache {

    @Override
    public void refresh() {
        // 原型模式就这么简单，拷贝已有对象的数据，更新少量差值
        HashMap<String, SearchWord> newKeywords = (HashMap<String, SearchWord>) ((HashMap<String, SearchWord>) currentKeywords).clone();

        List<SearchWord> toBeUpdatedSearchTime = repository.getSearchWords(lastUpdateTime);
        long maxNewUpdatedTime = lastUpdateTime;
        for (SearchWord searchWord : toBeUpdatedSearchTime) {
            if (searchWord.getLastUpdateTime() > maxNewUpdatedTime) {
                maxNewUpdatedTime = searchWord.getLastUpdateTime();
            }
            if (newKeywords.containsKey(searchWord.getKeyword())) {
                newKeywords.replace(searchWord.getKeyword(), searchWord);
            } else {
                newKeywords.put(searchWord.getKeyword(), searchWord);
            }
            lastUpdateTime = maxNewUpdatedTime;
            currentKeywords = newKeywords;
        }
    }

}
