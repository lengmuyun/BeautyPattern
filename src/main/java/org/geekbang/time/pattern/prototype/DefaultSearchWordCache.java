package org.geekbang.time.pattern.prototype;

import java.util.List;

public class DefaultSearchWordCache extends AbstractSearchWordCache {

    @Override
    public void refresh() {
        List<SearchWord> toBeUpdatedSearchWords = repository.getSearchWords(lastUpdateTime);
        long maxNewUpdatedTime = lastUpdateTime;
        for (SearchWord searchWord : toBeUpdatedSearchWords) {
            if (searchWord.getLastUpdateTime() > maxNewUpdatedTime) {
                maxNewUpdatedTime = searchWord.getLastUpdateTime();
            }
            if (currentKeywords.containsKey(searchWord.getKeyword())) {
                currentKeywords.replace(searchWord.getKeyword(), searchWord);
            } else {
                currentKeywords.put(searchWord.getKeyword(), searchWord);
            }
        }
        lastUpdateTime = maxNewUpdatedTime;
    }

}
